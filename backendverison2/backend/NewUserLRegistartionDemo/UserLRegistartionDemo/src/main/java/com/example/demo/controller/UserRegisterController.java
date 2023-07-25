package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserAlreadyExists;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.service.IUserRegisterService;

@RestController
@RequestMapping("api/register")
@CrossOrigin(origins="*")
public class UserRegisterController {
	
	@Autowired
	private IUserRegisterService userService;
	
	private ResponseEntity<?> responseEntity;
	
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<?> getUserByIdHandler(@PathVariable String userId) {
	    try {
	        User user = this.userService.getUserById(userId);
	        responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
	    } catch (UserNotFound e) {
	        System.out.println(e);
	    } catch (Exception e) {
	        System.out.println(e);
	        this.responseEntity = new ResponseEntity<>("Some internal error occurred..", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    return responseEntity;
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<?> addUserHandler(@RequestBody User uObj)throws UserAlreadyExists{
		try {
		User newUser = this.userService.addUser(uObj);
		responseEntity = new ResponseEntity<>("User added: "+newUser, HttpStatus.CREATED);
		}catch(UserAlreadyExists exception){
			throw exception;
		}catch(Exception e) {
			System.out.println(e);
			this.responseEntity = new ResponseEntity<>("Some internal error occured..", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUserHandler(){
		List<User> Users = this.userService.getAllUsers();
		responseEntity = new ResponseEntity<>(Users, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<?> getByEmailHandler(@PathVariable String email)throws UserNotFound{
		try {
		User userObj = this.userService.getUserByEmail(email);
		responseEntity = new ResponseEntity<>(userObj, HttpStatus.OK);
		}catch(UserNotFound e) {
			throw e;
		}catch(Exception e) {
			System.out.println(e);
			this.responseEntity = new ResponseEntity<>("Some internal error occured..", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PutMapping("/updateuser/{uid}")
    public ResponseEntity<?> updateUserHandler(@RequestBody User uobj,@PathVariable String uid)throws UserNotFound
    {
		try {
        User newUser = this.userService.updateUser(uobj,uid);
        responseEntity = new ResponseEntity<>(newUser,HttpStatus.CREATED);
		}catch(UserNotFound ex) {
			throw ex;
		}catch(Exception e) {
			System.out.println(e);
			this.responseEntity = new ResponseEntity<>("Some internal error occured..", HttpStatus.INTERNAL_SERVER_ERROR);
		}
        return responseEntity;
    }
	
	@DeleteMapping("/deluserbyid/{uid}")
    public ResponseEntity<?> DeleteUserByIdHandler(@PathVariable String uid)throws UserNotFound
    {
		try {
        boolean status = this.userService.delUser(uid);
        responseEntity = new ResponseEntity<>("User Details Deleted ....",HttpStatus.OK);
		}catch(UserNotFound u) {
			throw u;
		}catch(Exception e) {
			System.out.println(e);
			this.responseEntity = new ResponseEntity<>("Some internal error occured..", HttpStatus.INTERNAL_SERVER_ERROR);
		}
        return responseEntity;
    }

}
