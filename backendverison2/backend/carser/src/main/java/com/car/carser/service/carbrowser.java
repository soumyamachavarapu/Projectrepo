package com.car.carser.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.car.carser.model.Car;
import com.car.carser.repo.Icarrepo;


@Service
public class carbrowser implements Icarbrowser{
	@Autowired
	private Icarrepo car;

	@Override
	public List<Car> getAllDetails() {
		return this.car.findAll();
	}

	@Override
	public List<Car> getCarDetailsByCityOrState(String cityOrState, String state) {
		return car.findByCityOrState(cityOrState, state);
	}
	
	@Override
	public List<Car> getCarDetailsByuserID(String userID) {
		
		return car.findByuserID(userID);
	}

	@Override
	public boolean deleteCarById(String carId) {
		Optional<Car> optionalCar = car.findById(carId);
        if (optionalCar.isPresent()) {
        	car.deleteById(carId);
            return true;
        }
        return false;
	}

	@Override
	public Optional<Car> findCarById(String carId) {
		// TODO Auto-generated method stub
		return car.findBycarId(carId);
	}

	

	

	

	
	}
	
	
	

