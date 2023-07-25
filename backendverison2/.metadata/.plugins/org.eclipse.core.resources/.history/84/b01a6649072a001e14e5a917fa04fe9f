package com.car.carser.controller;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.car.carser.service.Icarbrowser;
import com.car.carser.service.Icarlist;
import com.car.carser.service.Ishortlist;

import com.car.carser.model.*;
import com.car.carser.repo.Icarrepo;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/cars/v1")
public class carcontroller {
	@Autowired
	private Icarbrowser carbrowse;
	@Autowired
	private Icarlist carpost;
	
	public ResponseEntity<?> responseEntity; 
	
	@GetMapping("/getByuserID/{userID}")
	public ResponseEntity<List<Car>>getCarDetailsByuserID(@PathVariable String userID){
		 if (userID==null) {
		        return ResponseEntity.badRequest().build();
		       
		    }
		 List<Car> carsByuserID;
		 System.out.println("got the id");
		 carsByuserID=carbrowse.getCarDetailsByuserID(userID);
		 return new ResponseEntity<>(carsByuserID,HttpStatus.OK);
	}
		
	@GetMapping("/browse")
	public ResponseEntity<?> getAlldetailsHandler(){
		System.out.println("test1");
		List<Car> allCars=this.carbrowse.getAllDetails();
		responseEntity = new ResponseEntity<>(allCars,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/browseByLocation/{cityOrState}")
	public ResponseEntity<List<Car>> getCarDetailsByLocation(@PathVariable("cityOrState") String cityOrState) {
	    List<Car> carsByLocation = carbrowse.getCarDetailsByCityOrState(cityOrState, cityOrState);
	   
	    if (carsByLocation.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	   
	    return new ResponseEntity<>(carsByLocation, HttpStatus.OK);
	}

	
	@Autowired
	private Icarlist carlist;
	
	@PostMapping("/list")
    public ResponseEntity<String> saveCarDetails(@RequestParam("carId") String carId,@RequestParam("userID") String userID,@RequestParam("brand") String brand,@RequestParam("model") String model,
    		@RequestParam("year") String year,@RequestParam("fueltype") String fueltype,@RequestParam("state") String state,
    		@RequestParam("kmsDriven") String kmsDriven,@RequestParam("city") String city,
    		@RequestParam("carType") String carType,@RequestParam("price") String price,
    		@RequestParam("condition") String condition,@RequestParam("shortlistingFlag") String shortlistingFlag,
    		@RequestParam(value="photo", required = false) MultipartFile photo, Model model1
    		) throws IOException {
		
		
		Car car=new Car(carId,userID,brand,model,year,fueltype,state,kmsDriven,
				 city,carType,price,condition, shortlistingFlag);
		
		Binary imageData =ImageConversion(photo);

        car.setPhoto(imageData);    

        String id = carlist.saveAllDetails(car);
		
		String output = carlist.saveAllDetails(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
	
	@Autowired
	private Ishortlist shortlist;
	
	@GetMapping("/shortlisted")
    public ResponseEntity<List<Car>> getShortlistedCars() {
        List<Car> shortlistedCars = shortlist.getShortlistedCars();
        System.out.println(shortlistedCars);
        return new ResponseEntity<>(shortlistedCars, HttpStatus.OK);
    }
	
	@Autowired
	public Icarrepo carRepo;
	
	
	@PutMapping("/shortlist/{carId}")
	public ResponseEntity<Void> updateShortlistingFlag(@PathVariable String carId, @RequestBody String shortlistingflag) {
	   System.out.println(carId);
	   System.out.println(shortlistingflag);
	   String Json="shortlistingflag";

	   
		Optional<Car> optionalCar = carRepo.findById(carId);
	    if (optionalCar.isPresent()) {
	        Car car = optionalCar.get();
	        
	        	
	        car.setShortlistingFlag(shortlistingflag);
	        carRepo.save(car);
	        return ResponseEntity.ok().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/car/{carId}")

    public ResponseEntity<Car> getCarById(@PathVariable String carId) {

        Optional<Car> optionalCar = carbrowse.findCarById(carId);

        if (optionalCar.isPresent()) {	

            Car car = optionalCar.get();

            return ResponseEntity.ok(car);

        } else {

            return ResponseEntity.notFound().build();

        }

    }
	
	@DeleteMapping("/delete/{carId}")
    public ResponseEntity<String> deleteCarDetails(@PathVariable String carId) {
        boolean deleted = carbrowse.deleteCarById(carId);
        if (deleted) {
            return ResponseEntity.ok("Car details deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	public Binary ImageConversion(MultipartFile photo) throws IOException {

        Binary imageData = new Binary(BsonBinarySubType.BINARY, photo.getBytes());

        return imageData;
        
    }
}





