package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableDiscoveryClient
@SpringBootApplication
@CrossOrigin(origins="**")	
public class UserLRegistartionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLRegistartionDemoApplication.class, args);
	}

}
