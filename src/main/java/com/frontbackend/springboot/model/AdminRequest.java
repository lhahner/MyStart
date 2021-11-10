package com.frontbackend.springboot.model;

public class AdminRequest {

	private String admin_id;
	private String first_name;
	private String last_name;
	
	//Getters
	public String getAdmin_id() {
		return admin_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	
	//Setters
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
}
