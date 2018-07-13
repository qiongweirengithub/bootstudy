package com.qw.study.scheduleserver.core;

import com.qw.study.scheduleserver.common.JobModule;
import com.qw.study.scheduleserver.core.taskstorage.ITaskStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * generate scheduled task and start it
 * @author qunar-qw
 * @date 18-7-12
 */
@Service
public class TaskGenerater {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskGenerater.class);

    @Autowired
    private ITaskStorage taskStorage;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        /**需要实例化线程*/
        taskScheduler.initialize();
        return taskScheduler;
    }

    public Trigger generateTrigger(String jobName) {
        LOGGER.info("生成触发器:{}", jobName);
        Trigger trigger =  new Trigger() {
            @Nullable
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                JobModule cron = taskStorage.queryOne(jobName);
                CronTrigger cronTrigger = new CronTrigger(cron.getCron());
                return cronTrigger.nextExecutionTime(triggerContext);
            }
        };
        return trigger;
    }

    public boolean generateTask(Runnable task, Trigger trigger) {
        try {
            taskScheduler.schedule(task, trigger);
        } catch (Exception e) {
            LOGGER.error("添加定时任务失败", e);
            return false;
        }
        return true;
    }

}