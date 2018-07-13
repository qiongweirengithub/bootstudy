package com.qw.study.scheduleserver.common;

import com.qw.study.scheduleserver.core.taskstorage.ITaskStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


/**
 * @author qunar-qw
 * @date 18-7-12
 */
public class TaskAction implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskAction.class);

    private String taskName;

    public TaskAction(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override public void run() {
        LOGGER.info("task -{}- running", taskName);
    }
}