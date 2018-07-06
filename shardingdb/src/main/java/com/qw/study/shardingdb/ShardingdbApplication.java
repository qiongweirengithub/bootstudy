package com.qw.study.shardingdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //排除DataSourceConfiguratrion
@MapperScan("com.qw.study.shardingdb.dal")
public class ShardingdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingdbApplication.class, args);
	}
}
