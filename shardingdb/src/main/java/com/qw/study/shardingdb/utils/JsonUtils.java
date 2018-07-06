package com.qw.study.shardingdb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author qunar-qw
 * @date 18-7-5
 */
public class JsonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);


    public static String toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object parseObject(String json, Class<?> clz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, clz);
        } catch (Exception e) {
            return null;
        }
    }


}