package com.applicationRouter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRouterApplication.class, args);
	}

}
