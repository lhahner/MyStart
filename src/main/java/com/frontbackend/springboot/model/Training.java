package com.frontbackend.springboot.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "training")
public class Training {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String trainingID;
    private String topic;
    private String start_time;
    private String end_time;
    private String training_date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    private String admin_id;
    
    public Training() {
	}

    public Training(String trainingID, String topic, String start_time, String end_time, String training_date,
			Trainer trainer, String admin_id) {
		this.trainingID = trainingID;
		this.topic = topic;
		this.start_time = start_time;
		this.end_time = end_time;
		this.training_date = training_date;
		this.trainer = trainer;
		this.admin_id = admin_id;
	}
    
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
	public String getAdmin_id() {
		return admin_id;
	}
	public Trainer getTrainer() {
		return trainer;
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
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	 
}