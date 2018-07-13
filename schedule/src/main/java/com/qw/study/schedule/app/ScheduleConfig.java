package com.qw.study.schedule.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author qunar-qw
 * @date 18-7-12
 */
@Component
public class ScheduleConfig implements SchedulingConfigurer{

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleConfig.class);



    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {


        Runnable task = new Runnable() {

            @Override
            public void run() {
                //任务逻辑代码部分.
                System.out.println("TaskCronChange task is running ... "+ new Date());
            }

        };

        Trigger trigger = new Trigger() {
            @Nullable
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {

                //任务触发，可修改任务的执行周期.

                CronTrigger trigger1 = new CronTrigger("");

                Date nextExec = trigger1.nextExecutionTime(triggerContext);

                return nextExec;

            }
        };

        taskRegistrar.addTriggerTask(task, trigger);

    }
}