package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//@CrossOrigin(origins = "http://localhost:4200")
@EnableDiscoveryClient
@CrossOrigin(origins="**")
public class OrderCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderCarApplication.class, args);
	}

}
