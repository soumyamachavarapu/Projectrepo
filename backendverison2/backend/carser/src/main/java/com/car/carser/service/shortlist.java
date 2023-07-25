package com.car.carser.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.carser.model.Car;
import com.car.carser.repo.Icarrepo;

@Service
public class shortlist implements Ishortlist {

	@Autowired
	 private Icarrepo carRepo;
		    

		    
//		    public List<Car> getShortlistedCars() {
//		        List<Car> cars = carRepo.findAll();
//		        return cars.stream()
//		                .filter(carx -> carx.getShortlistingFlag());
//		                .peek(carx -> carx.setShortlistingFlag(String.valueOf(carx.getShortlistingFlag())))
//		                .collect(Collectors.toList());
//
//
//
//		    }


	public List<Car> getShortlistedCars() {
	    List<Car> cars = carRepo.findAll();
	    return cars.stream()
	        .filter(carx -> Boolean.parseBoolean(carx.getShortlistingFlag()))
	        .collect(Collectors.toList());
	}

}
