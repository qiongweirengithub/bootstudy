package com.qw.study.shardingdb.common;

/**
 * @author qunar-qw
 * @date 18-7-4
 */

public class OrderInfo {

    String orderNo;
    String passageName;
    Integer orderType;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPassageName() {
        return passageName;
    }

    public void setPassageName(String passgeName) {
        this.passageName = passgeName;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}