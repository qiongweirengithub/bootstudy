package com.qw.study.shardingdb;

import com.qw.study.shardingdb.common.OrderInfo;
import com.qw.study.shardingdb.dal.sharding.OrderMapper;
import com.qw.study.shardingdb.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingdbApplicationTests {


	private static final Logger LOGGER = LoggerFactory.getLogger(ShardingdbApplicationTests.class);



	@Autowired
	private OrderMapper mapper;

	@Test
	public void contextLoads() {

		List<OrderInfo> orderInfoList = mapper.queryByOrderNo(null, 1, 3);

		LOGGER.info("{}",JsonUtils.toJson(orderInfoList));

	}

}
