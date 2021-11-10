package com.frontbackend.springboot.model;

public class TrainerRequest {

	private String trainer_id;
	private String first_name;
	private String last_name;
	private String email;
	private String job_title;
	private String telephone;
	private String linkedin_link;
	private String profile_pic;
	private String topics;
	
	//Getters
	public String getTrainer_id() {
		return trainer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getlinkedin_link() {
		return linkedin_link;
	}
	public String getProfile_pic() {
		return profile_pic;
	}
	public String getTopics() {
		return topics;
	}
	public String getJob_title() {
		return job_title;
	}
	
	//Setters
	public void setTrainer_id(String trainer_id) {
		this.trainer_id = trainer_id;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setlinkedin_link(String linkedin_link) {
		this.linkedin_link = linkedin_link;
	}
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	public void setTopics(String topics) {
		this.topics = topics;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
}
