package com.example.demo.controller;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.service.UserLogin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@RequestMapping("api/login")
@CrossOrigin(origins="*")
public class UserLoginController {

	@Autowired
	private UserLogin userlogin;
	

	private Map<String, String> map = new HashMap<>();
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUserHandler(@RequestBody User uObj){
		try {
			System.out.println(uObj);
			
			 User userObj = new User();
			uObj.setUserID(userObj.getUserID());
			System.out.println(uObj.getUserID());
			
			String jwtToken=generateToken(uObj);
			map.put("message", "User Successfully LoggedIn");
			map.put("token", jwtToken);
			map.put("userID", uObj.getUserID());
			System.out.println("controlleruserID"+uObj.getUserID());
			
		}catch(Exception e) {
			map.put("message", e.getMessage());
            map.put("token", null);
            return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}
		
		 return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	
//	private String generateToken(User UObj) throws ServletException,UserNotFound{
//		String jwtToken = "";
//		System.out.println("Iam here serv");
//		String flag = this.userlogin.validateUser(UObj);
//		System.out.println("Iam here serv12");
//		if(flag == "User Not Found!" ) {
//			
//			throw new ServletException("Invalid Credentials");
//			
//		}
//		else if((flag=="Wrong Password")) {
//			throw new ServletException("wrong password");
//		}
//		else {
//			
//			String userID=UObj.getUserID();
//			
//			Map<String, Object> claims = new HashMap<>();
//	        claims.put("userID", userID);
//	        
//			System.out.println("Iam here");
//			jwtToken=Jwts.builder().setSubject(UObj.getUemail()).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 3000000)).signWith(SignatureAlgorithm.HS256, "secret key").setClaims(claims).compact();
//		}
//		System.out.print(jwtToken);
//		return jwtToken;
//	}
	
	private String generateToken(User UObj) throws ServletException, UserNotFound {
	    String jwtToken = "";
	    String flag = this.userlogin.validateUser(UObj);

	    if (flag.equals("User Not Found!")) {
	        throw new ServletException("Invalid Credentials");
	    } else if (flag.equals("Wrong Password")) {
	        throw new ServletException("Wrong Password");
	    } else {
	        String userID = UObj.getUserID(); // Assuming you have a method to retrieve the userID from the User object or database

	        Map<String, Object> claims = new HashMap<>();
	        
	        System.out.println(userID);
	        claims.put("userID", userID); // Add the userID to the claims

	        // Generate the JWT token with the userID in the payload
	        jwtToken = Jwts.builder()
	                .setSubject(UObj.getUemail())
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 3000000))
	                .signWith(SignatureAlgorithm.HS256, "secret key")
	                .setClaims(claims) // Add the claims to include userID
	                .compact();
	    }

	    return jwtToken;
	}


}

