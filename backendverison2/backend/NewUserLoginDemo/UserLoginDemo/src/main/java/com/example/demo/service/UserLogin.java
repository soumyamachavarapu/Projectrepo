package com.example.demo.service;

import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;

public interface UserLogin {

	public String validateUser(User uObj)throws UserNotFound;

}

