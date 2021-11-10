package com.frontbackend.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontbackend.springboot.model.Training;
import com.frontbackend.springboot.model.TrainingRequest;
import com.frontbackend.springboot.repository.TrainingRepository;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Optional<Training> findById(String id) {
        return trainingRepository.findById(id);
    }

    public String save(TrainingRequest request) {
        Training training = new Training();
        training.setAdmin_id(request.getAdmin_id());
        training.setEnd_time(request.getEnd_time());
        training.setStart_time(request.getStart_time());
        training.setTopic(request.getTopic());
        training.setTrainerID(request.getTrainerID());
        training.setTraining_date(request.getTraining_date());

        return trainingRepository.save(training).getTrainingID();
    }

    public void update(String id, TrainingRequest request) {
        Optional<Training> training = findById(id);
        if (training.isPresent()) {
            Training forUpdate = training.get();
            forUpdate.setTopic(request.getTopic());
            forUpdate.setStart_time(request.getStart_time());
            forUpdate.setEnd_time(request.getEnd_time());
            forUpdate.setTrainerID(request.getTrainerID());
            forUpdate.setTraining_date(request.getTraining_date());
            trainingRepository.save(forUpdate);
        }
    }
    
    @Transactional
    public List<Training> getAll() { 	
        return trainingRepository.findAll();
    }

    public List<Training> findByTopic(String topic) {
        return trainingRepository.findAllByTopicContaining(topic);
    }

    public void delete(String id) {
        Optional<Training> training = findById(id);
        training.ifPresent(trainingRepository::delete);
    }

}