package com.car.carser.service;
import java.util.List;
import java.util.Optional;

import com.car.carser.model.*;

public interface Icarbrowser {
	public List<Car> getAllDetails();
	public List<Car> getCarDetailsByCityOrState(String city, String state);
	public boolean deleteCarById(String carId);
	public List<Car>getCarDetailsByuserID(String userID);

	public Optional<Car> findCarById(String carId);
}
