package com.frontbackend.springboot.service;

import com.frontbackend.springboot.model.Training;
import com.frontbackend.springboot.model.TrainingDelete;
import com.frontbackend.springboot.model.TrainingRequest;
import com.frontbackend.springboot.repository.TrainingDeleteRepository;
import com.frontbackend.springboot.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingDeleteService {

    private final TrainingDeleteRepository trainingDeleteRepository;

    @Autowired
    public TrainingDeleteService(TrainingDeleteRepository trainingDeleteRepository) {
        this.trainingDeleteRepository = trainingDeleteRepository;
    }

    public Optional<TrainingDelete> findById(String id) {
        return trainingDeleteRepository.findById(id);
    }

    @Transactional
    public List<TrainingDelete> getAll() {
        return trainingDeleteRepository.findAll();
    }

    public List<TrainingDelete> findByTopic(String topic) {
        return trainingDeleteRepository.findAllByTopicContaining(topic);
    }

    public void delete(String id) {
        Optional<TrainingDelete> training = findById(id);
        training.ifPresent(trainingDeleteRepository::delete);
    }

}