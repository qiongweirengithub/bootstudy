package com.qw.study.shardingdb.app.web.vo;

import com.qw.study.shardingdb.common.OrderInfo;

/**
 * @author qunar-qw
 * @date 18-7-5
 */
public class OrderVo {

    Integer orderType;
    String orderNo;
    String passageName;


    /**
     * 接收前端参数需要这个无参数的构造器
     */
    public OrderVo() {
    }

    public OrderVo(OrderInfo orderInfo) {
        this.orderNo = orderInfo.getOrderNo();
        this.passageName = orderInfo.getPassageName();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPassageName() {
        return passageName;
    }

    public void setPassageName(String passageName) {
        this.passageName = passageName;
    }
}