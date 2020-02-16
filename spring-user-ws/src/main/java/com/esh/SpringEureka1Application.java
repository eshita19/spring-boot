package com.esh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringEureka1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringEureka1Application.class, args);
	}

}
