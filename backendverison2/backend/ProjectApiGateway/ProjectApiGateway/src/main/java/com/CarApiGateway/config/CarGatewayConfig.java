package com.CarApiGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarGatewayConfig {

	@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder) 
	{
		
//		Static Routing
		return builder.routes()
				.route("userID", r->r.path("/api/register/**").uri("http://localhost:7000"))
				.route("uemail", r->r.path("/api/login/**").uri("http://localhost:8085"))
				.route("order_id", r->r.path("/api/order/**").uri("http://localhost:8087"))
				.route("carId", r->r.path("/cars/v1/**").uri("http://localhost:8000"))
//				.route("slotid", r->r.path("/slot/v1/**").uri("http://localhost:8089"))
//				.route("userID", r->r.path("/users/**").uri("http://localhost:8083"))
//				.route("userID", r->r.path("/admin/**").uri("http://localhost:8888"))
				.build();
//		
		
//		Dynamic Routing
//		return builder.routes()
//				.route("userID", r->r.path("/api/register/**").uri("http://localhost:7000"))
//				.route("order_id", r->r.path("/api/v1/**").uri("http://localhost:8087"))
//				.build();
//		
	}

}
