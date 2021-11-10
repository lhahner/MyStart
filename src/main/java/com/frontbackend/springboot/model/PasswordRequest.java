package com.frontbackend.springboot.model;

public class PasswordRequest {

	private String groupid;
	private String pw;
	private String groupname;
	
	//Getters
	public String getGroupid() {
		return groupid;
	}
	public String getPw() {
		return pw;
	}
	public String getGroupname() {
		return groupname;
	}
	
	//Setters
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	
	
	
}
