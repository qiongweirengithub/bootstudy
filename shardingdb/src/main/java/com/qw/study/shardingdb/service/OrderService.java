package com.qw.study.shardingdb.service;

import com.qw.study.shardingdb.common.OrderInfo;
import com.qw.study.shardingdb.dal.sharding.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qunar-qw
 * @date 18-7-5
 */
@Service
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderInfo> queryByOrderNo(String orderNo, Integer current, Integer limit) {
        try {
            return orderMapper.queryByOrderNo(orderNo, current, limit);
        } catch (Exception e) {
            LOGGER.error("dao error", e);
        }
        return null;
    }

    public boolean insert(OrderInfo orderInfo) {
        try {
            orderMapper.insertSelective(orderInfo);
        } catch (Exception e) {
            LOGGER.error("dao error", e);
        }
        return true;
    }

}