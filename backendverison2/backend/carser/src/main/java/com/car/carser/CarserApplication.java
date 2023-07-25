package com.car.carser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="**")
@SpringBootApplication
@EnableDiscoveryClient
public class CarserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarserApplication.class, args);
	}

}

