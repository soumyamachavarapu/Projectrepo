package com.example.demo.model;

public class User {
	
	private String userID;
    private String uemail;
	private String upass;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", uemail=" + uemail + ", upass=" + upass + "]";
	}
	
	
	
	}
	
	
    

