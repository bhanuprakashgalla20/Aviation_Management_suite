package com.aviationmanagementsuite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AviationManagementSuiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AviationManagementSuiteApplication.class, args);
	}

}
