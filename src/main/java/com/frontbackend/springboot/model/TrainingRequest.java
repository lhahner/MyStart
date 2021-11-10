package com.frontbackend.springboot.model;

public class TrainingRequest {
	
	private String trainingID;
    private String topic;
    private String start_time;
    private String end_time;
    private String training_date;
    private String trainer;
    private String admin_id;
    
    //Getters
	public String getTrainingID() {
		return trainingID;
	}
	public String getTopic() {
		return topic;
	}
	public String getStart_time() {
		return start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public String getTraining_date() {
		return training_date;
	}
	public String getTrainerID() {
		return trainer;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	
	//Setters
	public void setTrainingID(String trainingID) {
		this.trainingID = trainingID;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public void setTraining_date(String training_date) {
		this.training_date = training_date;
	}
	public void setTrainerID(String trainer) {
		this.trainer = trainer;
	}
	public void setAdmin_ks(String admin_id) {
		this.admin_id = admin_id;
	}
    
    

}