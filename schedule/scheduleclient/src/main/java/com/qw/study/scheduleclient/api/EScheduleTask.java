package com.qw.study.scheduleclient.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * schedule task client api
 * @author qunar-qw
 * @date 18-7-13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EScheduleTask {

    /**
     * define the Task group
     * @return group
     */
    String group() default "NONE";
    /**
     * define the Task jobName
     * @return group
     */
    String jobName() default "NONE";
    /**
     * define the Task Trigger cron
     * @return group
     */
    String cron() default "1 1 1 1 1 *";
}
