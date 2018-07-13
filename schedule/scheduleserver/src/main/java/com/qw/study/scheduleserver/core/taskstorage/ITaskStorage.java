package com.qw.study.scheduleserver.core.taskstorage;

import com.qw.study.scheduleserver.common.JobModule;

import java.util.List;

/**
 * @author qunar-qw
 * @date 18-7-12
 */
public interface ITaskStorage {

    List<JobModule> queryAll();

    JobModule queryOne(String id);

    boolean insertOne(JobModule taskModule);

    boolean update(JobModule taskModule);

    boolean delete(String id);

}