package com.example.demo.service;

import java.time.Instant;
import java.util.List;

import java.util.Optional;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAlreadyExists;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRegisterRepository;

@Service
public class UserRegisterServiceImpl implements IUserRegisterService {
	
	@Autowired
	private IUserRegisterRepository userrepository;
	
	

	@Override
	public User addUser(User uObj) throws UserAlreadyExists{
		int desiredLength = 10;
		
		Random random = new Random();
        int randomUserId = random.nextInt(1000) + 1; // Generates a random integer from 1 to 1000
        String uniqueId = Instant.now().toEpochMilli() + "-" + randomUserId;
	    uObj.setUserID(uniqueId);
	    uObj.setUserID(String.valueOf(randomUserId));
	    
		
		
		// Generate a random UUID
//		String randomUserId = UUID.randomUUID().toString();

		// Truncate the randomUserId to the desired length
//		String truncatedUserId = randomUserId.substring(0, desiredLength);

		// Set the truncatedUserId as the user ID
//		uObj.setUserID(truncatedUserId);
        
		Optional<User> optional = userrepository.findById(uObj.getUserID());
		User adduobj = null;
		
		if(optional.isPresent())
		{
			System.out.println("User Details already exists ...");
		}
		else
		{		
			adduobj = userrepository.save(uObj);
		}
		return adduobj;
	}

	@Override
	public List<User> getAllUsers() {
		return this.userrepository.findAll();
	}

	@Override
	public User getUserByEmail(String email)throws UserNotFound {
		
		Optional<User> userOptional = this.userrepository.findByUemail(email);
	    User uObj = null;
	    if (userOptional.isPresent()) {
	        uObj = userOptional.get();
	        System.out.println(uObj);
	    } else {
	        System.out.println("User does not exist");
	    }
	    return uObj;
	}

	@Override
	public User updateUser(User uobj, String uid) throws UserNotFound {
		Optional<User> userOptional = this.userrepository.findByUserID(uid);
        User uObj = null;
        User updatedData = null;

        if(userOptional.isPresent())
        {
            System.out.println("Record Exists and ready for Update !!!");

            uObj = userOptional.get();
            uObj.setUemail(uobj.getUemail());
            uObj.setUpass(uobj.getUpass());
            uObj.setMobilenumber(uobj.getMobilenumber());
            uObj.setUname(uobj.getUname());
            uObj.setAddress(uobj.getAddress());
            
            updatedData = this.userrepository.save(uObj);
        }
        return updatedData;
	}

	@Override
	public boolean delUser(String uid) throws UserNotFound {
		Optional<User> userOptional = this.userrepository.findByUserID(uid);
        boolean status=false;
        
        if(userOptional.isPresent())
        {
            System.out.println("Record Exists and ready for Delete !!!");

            this.userrepository.delete(userOptional.get());
            status=true;
        }
        else
        {
            System.out.println("User details does not exits for delete ..");
        }
        return status;
	}

	@Override
	public User getUserById(String uid) throws UserNotFound {
		 Optional<User> userOptional = userrepository.findByUserID(uid);
	        
	        if (userOptional.isPresent()) {
	            return userOptional.get();
	        } else {
	        	throw new UserNotFound("User not found for ID: " + uid);
	        }
	}
}
