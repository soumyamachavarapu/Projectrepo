package com.order.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Document
public class Order {
	
	 	@Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private String order_id;
	 	private String userID;
	    private Date order_date;
	    private boolean status;
	    private String car_id;
	    private Date order_time;
		public String getOrder_id() {
			return order_id;
		}
		public void setOrder_id(String order_id) {
			this.order_id = order_id;
		}
		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
		public Date getOrder_date() {
			return order_date;
		}
		public void setOrder_date(Date order_date) {
			this.order_date = order_date;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public String getCar_id() {
			return car_id;
		}
		public void setCar_id(String car_id) {
			this.car_id = car_id;
		}
		public Date getOrder_time() {
			return order_time;
		}
		public void setOrder_time(Date order_time) {
			this.order_time = order_time;
		}
		@Override
		public String toString() {
			return "Order [order_id=" + order_id + ", userID=" + userID + ", order_date=" + order_date + ", status="
					+ status + ", car_id=" + car_id + ", order_time=" + order_time + "]";
		}
		
	    
	    
		

		
}
