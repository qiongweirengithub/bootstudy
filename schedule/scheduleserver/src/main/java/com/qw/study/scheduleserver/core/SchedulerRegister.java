package com.qw.study.scheduleserver.core;

import com.qw.study.scheduleserver.common.JobModule;
import com.qw.study.scheduleserver.common.TaskAction;
import com.qw.study.scheduleserver.core.taskstorage.ITaskStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.stereotype.Service;

/**
 * @author qunar-qw
 * @date 18-7-12
 */
@Service
public class SchedulerRegister {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerRegister.class);

    @Autowired
    private ITaskStorage taskStorage;

    @Autowired
    private TaskGenerater taskGenerater;

    public void register(String taskName) {
        LOGGER.info("开始注册定时任务到服务器-> jobName:{}", taskName);
        try {
            JobModule jobModule = taskStorage.queryOne(taskName);
            Trigger trigger = taskGenerater.generateTrigger(jobModule.getTaskName());
            TaskAction task = new TaskAction(taskName);
            taskGenerater.generateTask(task, trigger);
        } catch (Exception e) {
            LOGGER.error("注册定时任务-{}-失败", taskName, e);
        }
    }

}