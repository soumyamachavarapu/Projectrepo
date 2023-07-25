package com.car.carser.model;
import java.util.Arrays;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {
		@Id
		private String carId;
		private String userID;
		private String brand;
	    private String model;
	    private String year;
	    private String fueltype;
	    private String state;
	    private String kmsDriven;
	    private String city;
	    private String carType;
	    private Binary photo;
		private String price;
	    private String condition;
	    private String shortlistingFlag;
		public String getCarId() {
			return carId;
		}
		public void setCarId(String carId) {
			this.carId = carId;
		}
		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public String getFueltype() {
			return fueltype;
		}
		public void setFueltype(String fueltype) {
			this.fueltype = fueltype;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getKmsDriven() {
			return kmsDriven;
		}
		public void setKmsDriven(String kmsDriven) {
			this.kmsDriven = kmsDriven;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCarType() {
			return carType;
		}
		public void setCarType(String carType) {
			this.carType = carType;
		}
		public Binary getPhoto() {
			return photo;
		}
		public void setPhoto(Binary photo) {
			this.photo = photo;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public String getShortlistingFlag() {
			return shortlistingFlag;
		}
		public void setShortlistingFlag(String shortlistingFlag) {
			this.shortlistingFlag = shortlistingFlag;
		}
		@Override
		public String toString() {
			return "Car [carId=" +carId+ ",userID=" + userID + ", brand=" + brand + ", model=" + model + ", year=" + year + ", fueltype="
					+ fueltype + ", state=" + state + ", kmsDriven=" + kmsDriven + ", city=" + city + ", carType="
					+ carType + ", photo=" + photo + ", price=" + price + ", condition=" + condition
					+ ", shortlistingFlag=" + shortlistingFlag + "]";
		}
		public Car() {
			super();
		}
		public Car(String carId,String userID, String brand, String model, String year, String fueltype, String state,
				String kmsDriven, String city, String carType, String price, String condition,
				String shortlistingFlag) {
			super();
			this.userID = userID;
			this.brand = brand;
			this.model = model;
			this.year = year;
			this.fueltype = fueltype;
			this.state = state;
			this.kmsDriven = kmsDriven;
			this.city = city;
			this.carType = carType;
			this.price = price;
			this.condition = condition;
			this.shortlistingFlag = shortlistingFlag;
		}
		public Car(Binary photo) {
			super();
			this.photo = photo;
		}
		

		
	    
		
}
