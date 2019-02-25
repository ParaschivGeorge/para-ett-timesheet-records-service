package com.paraett.timesheetrecordsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TimesheetRecordsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetRecordsServiceApplication.class, args);
	}

}
