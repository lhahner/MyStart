package com.frontbackend.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pwd_all")
public class Password {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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
