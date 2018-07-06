package com.qw.study.shardingdb.dal.sharding;

import com.qw.study.shardingdb.common.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qunar-qw
 * @date 18-7-4
 */
@Repository
public interface OrderMapper {

    List<OrderInfo> queryByOrderNo(@Param("orderNo") String orderNo, @Param("current") Integer current, @Param("limit") Integer limit);

    void insertSelective(OrderInfo orderInfo);

}