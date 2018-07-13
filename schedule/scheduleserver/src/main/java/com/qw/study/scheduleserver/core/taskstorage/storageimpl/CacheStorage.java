package com.qw.study.scheduleserver.core.taskstorage.storageimpl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import com.qw.study.scheduleserver.common.JobModule;
import com.qw.study.scheduleserver.core.taskstorage.ITaskStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author qunar-qw
 * @date 18-7-12
 */
@Service
public class CacheStorage implements ITaskStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheStorage.class);

    private Cache<String, JobModule> cache =  CacheBuilder.newBuilder().build();

    @Override
    public List<JobModule> queryAll() {
        List<JobModule> tasks = Lists.newArrayList();
        Map<String, JobModule> taskMap = cache.asMap();
        tasks.addAll(taskMap.values());
        return tasks;
    }

    @Override
    public JobModule queryOne(String key) {
       return cache.getIfPresent(key);
    }

    @Override
    public boolean insertOne(JobModule JobModule) {
        cache.put(JobModule.getTaskName(), JobModule);
        return false;
    }

    @Override
    public boolean update(JobModule JobModule) {
        try {
            cache.put(JobModule.getTaskName(), JobModule);
        } catch (Exception e) {
            LOGGER.error("更新任务是失败-> jobName: {}", JobModule.getTaskName(), e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String name) {
        try {
            cache.invalidate(name);
        } catch (Exception e) {
            LOGGER.error("任务删除失败-> jobName:{}", name);
        }
        return true;
    }

}