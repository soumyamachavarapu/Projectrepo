package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFound;
import com.example.demo.feign.UserFeign;
import com.example.demo.model.User;

@Service
public class UserLoginServiceImpl implements UserLogin {
	
	@Autowired
	private UserFeign userConsumer;

	@Override
	public String validateUser(User uObj)throws UserNotFound {
		System.out.println("validate");
//		User userObj = this.userConsumer.getByEmailHandler(uObj.getUserID());
		User userObj = this.userConsumer.getByEmailHandler(uObj.getUemail());
		
		uObj.setUserID(userObj.getUserID());
		System.out.println("returned"+userObj);
		System.out.println("serviceuserId"+userObj.getUserID());
		if(userObj != null) {
			if(userObj.getUpass().trim().equals(uObj.getUpass().trim())) {
				System.out.println("hi");
				return "User Authenticated Successfully!!";
				
			}else {
				System.out.println("Wrong Password");
				return "Wrong Password";
			}
		}else {
			System.out.println("User Not Found!");
			return "User Not Found!";
		}
	}

}
