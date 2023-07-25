package com.car.carser.service;
import java.util.Random;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.carser.model.*;
import com.car.carser.repo.Icarrepo;
import java.time.Instant;
@Service
public class carlist implements Icarlist {

	@Autowired
    private Icarrepo carRepo;


	@Override
	public String saveAllDetails(Car carObj) {
		
//		String randomcarID = UUID.randomUUID().toString();
//		carObj.setCarId(randomcarID);
//
//		Random random = new Random();
//		int randomcarID = random.nextInt(); // Generates a random integer
		
//int desiredLength = 10;
		
//		Random random = new Random();
//        int randomId = random.nextInt(1000) + 1; // Generates a random integer from 1 to 1000
//        String uniqueId = Instant.now().toEpochMilli() + "-" + randomUserId;
//	    carObj.setCarId(uniqueId);
//	    carObj.setCarId(String.valueOf(randomUserId));
		
		Car photo = new Car(carObj.getCarId(),carObj.getUserID(),carObj.getBrand(),carObj.getModel(),carObj.getYear(),carObj.getFueltype(),carObj.getState(),carObj.getKmsDriven(),
				 carObj.getCity(),carObj.getCarType(),carObj.getPrice(),carObj.getCondition(), carObj.getShortlistingFlag());
		
		byte[] imageData = carObj.getPhoto().getData();

        photo.setPhoto(new org.bson.types.Binary(imageData));

 

        photo = this.carRepo.insert(photo);


		Random random = new Random();
		int randomuserID = random.nextInt(1000) + 1; // Generates a random integer from 1 to 1000

		String uniqueId = Instant.now().toEpochMilli() + "-" + randomuserID;
		carObj.setCarId(uniqueId);


		carObj.setCarId(String.valueOf(randomuserID));
//		
		String output;
//		
		Optional<Car> carOptional = this.carRepo.findById(carObj.getCarId());
		if(carOptional.isPresent()) {
			output="Car Details already exists";
			return output;
		}else {
			this.carRepo.save(carObj);
			output="Car details added sucessfully";
			return output;
			
		}
		
	}

}
