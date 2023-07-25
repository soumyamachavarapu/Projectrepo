package com.example.demo.service;


import java.util.List;

import com.example.demo.exception.UserAlreadyExists;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;

public interface IUserRegisterService {
    public User addUser(User uObj) throws UserAlreadyExists;
    public List<User> getAllUsers();
    public User getUserByEmail(String email) throws UserNotFound;
    public User updateUser(User uobj, String uid) throws UserNotFound;
    public boolean delUser(String uid) throws UserNotFound;
    public User getUserById(String uid) throws UserNotFound;
}

