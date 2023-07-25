package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface IUserRegisterRepository extends JpaRepository<User, String> {
	
	public Optional<User> findByUemail(String uemail);

	public Optional<User> findByUserID(String userID);


}
