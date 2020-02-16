package com.esh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Access Account service using http://localhost:8011/account-ws/accounts/status
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulApplication.class, args);
	}

}
