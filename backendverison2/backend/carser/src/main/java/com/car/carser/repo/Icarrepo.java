package com.car.carser.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.car.carser.model.Car;

@Repository
public interface Icarrepo extends MongoRepository<Car, String> {
	List<Car> findByCityOrState(String cityOrState,String state);
	public List<Car> findByuserID(String userID);
	public Optional<Car> findBycarId(String carId);
}
