package com.qw.study.scheduleserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduleserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleserverApplication.class, args);
	}
}
