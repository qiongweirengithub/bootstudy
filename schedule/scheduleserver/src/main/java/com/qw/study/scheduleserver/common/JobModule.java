package com.qw.study.scheduleserver.common;

import com.qw.study.scheduleserver.app.web.vo.JobVo;
import org.springframework.beans.BeanUtils;

/**
 * @author qunar-qw
 * @date 18-7-12
 */
public class JobModule {

    private String jobName;
    private String hostIp;
    private String group;
    private String cron;

    public JobModule(JobVo jobVo) {
        BeanUtils.copyProperties(jobVo, this);
    }

    public JobModule(String taskName, String hostIp, String group, String cron) {
        this.jobName = taskName;
        this.hostIp = hostIp;
        this.group = group;
        this.cron = cron;
    }

    public String getTaskName() {
        return jobName;
    }

    public void setTaskName(String taskName) {
        this.jobName = taskName;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}