package com.qw.study.scheduleserver.app.web;

import com.qw.study.scheduleserver.app.web.vo.JobVo;
import com.qw.study.scheduleserver.app.web.vo.ResponseVo;
import com.qw.study.scheduleserver.common.JobModule;
import com.qw.study.scheduleserver.core.taskstorage.ITaskStorage;
import com.qw.study.scheduleserver.core.SchedulerRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * http://localhost:8080/register?jobName=&&task2&&ip=mockIp&&cron=0/5%20*%20*%20*%20*%20*
 * http://localhost:8080/register?jobName=%22task1%22&ip=%22xx%22&cron=%22cc%22
 * @author qunar-qw
 * @date 18-7-12
 */
@Controller
public class ManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagementController.class);

    @Autowired
    private ITaskStorage taskStorage;

    @Autowired
    private SchedulerRegister schedulerRegister;

    @RequestMapping("register")
    @ResponseBody
    public ResponseVo register(String jobName, String ip, String cron) {
        LOGGER.info("接收到添加任务请求->  jobName:{}, host:{}, cron:{}", jobName, ip, cron);
        try {
            taskStorage.insertOne(new JobModule(jobName, ip, "", cron));
            schedulerRegister.register(jobName);
        } catch (Exception e) {
            LOGGER.error("任务注册失败");
        }
        return new ResponseVo();
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public ResponseVo queryAll() {
        try {
            List<JobModule> taskModuleList = taskStorage.queryAll();
            return ResponseVo.createTrue(taskModuleList);
        } catch (Exception e) {
            LOGGER.error("任务注册失败");
        }
        return new ResponseVo();
    }

    @RequestMapping("query")
    @ResponseBody
    public ResponseVo query(String name) {
        try {
            JobModule taskModule = taskStorage.queryOne(name);
            return ResponseVo.createTrue(taskModule);
        } catch (Exception e) {
            LOGGER.error("任务注册失败");
        }
        return new ResponseVo();
    }

    @RequestMapping("update")
    @ResponseBody
    public ResponseVo update(JobVo jobVo) {
        LOGGER.info("更新定时任务:{}", jobVo.toString());
        try {
            taskStorage.update(new JobModule(jobVo));
            return ResponseVo.createTrue(null);
        } catch (Exception e) {
            LOGGER.error("任务更新失败");
        }
        return new ResponseVo();
    }

}