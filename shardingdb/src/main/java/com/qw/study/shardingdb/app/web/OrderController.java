package com.qw.study.shardingdb.app.web;

import com.qw.study.shardingdb.app.web.vo.OrderVo;
import com.qw.study.shardingdb.app.web.vo.ResponseVo;
import com.qw.study.shardingdb.common.OrderInfo;
import com.qw.study.shardingdb.service.OrderService;
import com.qw.study.shardingdb.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qunar-qw
 * @date 18-7-5
 */
@RestController
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping("search")
    public ResponseVo search(String orderNo, Integer current, Integer limit) {
        LOGGER.info("orderNo:{}", orderNo);
        try {
            List<OrderInfo> orderInfo = orderService.queryByOrderNo(orderNo, current, limit);
            return ResponseVo.createSucc(orderInfo);
        } catch (Exception e) {
            LOGGER.error("error:{}", orderNo, e);
            return ResponseVo.createFail();
        }
    }

    @RequestMapping("insert")
    public ResponseVo insert(OrderVo orderVo) {
        LOGGER.info("orderInfo:{}", JsonUtils.toJson(orderVo));
        try {
            orderService.insert(convert(orderVo));
        } catch (Exception e) {
            LOGGER.error("error:{}", JsonUtils.toJson(orderVo), e);
            return ResponseVo.createFail();
        }
        return ResponseVo.createSucc();
    }



    private OrderInfo convert(OrderVo vo) {
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(vo, orderInfo);
        return orderInfo;
    }

}