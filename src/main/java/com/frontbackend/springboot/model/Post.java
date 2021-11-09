package com.frontbackend.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "training")
public class Post {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String trainingID;
    private String topic;
    private String start_time;
    private String end_time;
    private String training_date;
    private int trainer;
    private int admin_ks;
    
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
	public int getTrainer() {
		return trainer;
	}
	public int getAdmin_ks() {
		return admin_ks;
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
	public void setTrainer(int trainer) {
		this.trainer = trainer;
	}
	public void setAdmin_ks(int admin_ks) {
		this.admin_ks = admin_ks;
	}
	

	
	 
}