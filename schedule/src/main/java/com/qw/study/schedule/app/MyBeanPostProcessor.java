package com.qw.study.schedule.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * 预处理所有spring的bean, 实现接口
 * @see BeanPostProcessor
 * @author qunar-qw
 * @date 18-7-11
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    @Nullable @Override public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        logger.info("=========Post process beans:{}", beanName);
        return bean;
    }

    @Nullable @Override public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }
}