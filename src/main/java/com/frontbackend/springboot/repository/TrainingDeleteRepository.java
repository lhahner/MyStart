package com.frontbackend.springboot.repository;

import com.frontbackend.springboot.model.Training;
import com.frontbackend.springboot.model.TrainingDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingDeleteRepository extends JpaRepository<TrainingDelete, String> {

    List<TrainingDelete> findAllByTopicContaining(String topic);
    
}