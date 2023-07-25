package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.User;

@FeignClient(name="register-service", url="http://localhost:7000/api/register")
public interface UserFeign {
	

		@GetMapping("/getByEmail/{uemail}")
		public User getByEmailHandler(@PathVariable String uemail);


}
