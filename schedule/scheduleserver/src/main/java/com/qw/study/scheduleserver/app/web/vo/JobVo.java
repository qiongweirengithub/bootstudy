package com.qw.study.scheduleserver.app.web.vo;

/**
 * @author qunar-qw
 * @date 18-7-13
 */
public class JobVo {


    private String jobName;
    private String hostIp;
    private String group;
    private String cron;

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

    @Override public String toString() {
        return "JobVo{" + "taskName='" + jobName + '\'' + ", hostIp='" + hostIp + '\'' + ", group='" + group + '\''
                + ", cron='" + cron + '\'' + '}';
    }
}