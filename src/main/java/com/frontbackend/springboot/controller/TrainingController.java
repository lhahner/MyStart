package com.frontbackend.springboot.controller;

import java.util.List;
import java.util.Optional;

import com.frontbackend.springboot.model.*;
import com.frontbackend.springboot.service.TrainerService;
import com.frontbackend.springboot.service.TrainingDeleteService;
import com.frontbackend.springboot.service.TrainingPostRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frontbackend.springboot.service.TrainingService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/training")
public class TrainingController {

    private final TrainingService trainingService;
    private final TrainerService trainerService;
    private final TrainingDeleteService trainingDeleteService;

    @Autowired
    public TrainingController(TrainingService trainingService, TrainerService trainerService, TrainingDeleteService trainingDeleteService) {
        this.trainingService = trainingService;
        this.trainerService = trainerService;
        this.trainingDeleteService = trainingDeleteService;
    }


    @GetMapping("{id}")
    public ResponseEntity<Training> training(@PathVariable String id) {
        Optional<Training> training = trainingService.findById(id);
        return training.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Training> list(@RequestParam(required = false) String topic) {
        if (StringUtils.isEmpty(topic)) {
            return trainingService.getAll();
        }
        return trainingService.findByTopic(topic);
    }

    @PostMapping
    public String save(@RequestBody TrainingPostRequest input) {
        TrainingPostRequest in = TrainingPostRequestService.saveUpdatePost(input);
        TrainingRequest request = new TrainingRequest();
        Trainer TD = new Trainer();
        request.setTrainer(trainerService.findById(in.getTrainerID()).orElse(TD));
        request.setTrainingID("0");
        request.setTopic(in.getTopic());
        request.setStart_time(in.getStart_time());
        request.setEnd_time(in.getEnd_time());
        request.setTraining_date(in.getTraining_date());
        request.setAdmin_id("1");
        return trainingService.save(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody TrainingPostRequest request) {
        Optional<TrainingDelete> training = trainingDeleteService.findById(id);
        if (training.isPresent()) {
            trainingDeleteService.update(id, request);
        } else {
            trainingDeleteService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        trainingDeleteService.delete(id);
    }
}