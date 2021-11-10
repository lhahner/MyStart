package com.frontbackend.springboot.model;

public class TrainingPostRequest {
    private String trainingID;
    private String topic;
    private String start_time;
    private String end_time;
    private String training_date;
    private String trainerID;
    private String admin_id;

    public TrainingPostRequest() {
    }

    public String getTrainingID() {
        return trainingID;
    }

    public void setTrainingID(String trainingID) {
        this.trainingID = trainingID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getTraining_date() {
        return training_date;
    }

    public void setTraining_date(String training_date) {
        this.training_date = training_date;
    }

    public String getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(String trainerID) {
        this.trainerID = trainerID;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
}
