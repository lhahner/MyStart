package com.frontbackend.springboot.controller;

import java.util.List;
import java.util.Optional;

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

import com.frontbackend.springboot.model.Training;
import com.frontbackend.springboot.model.TrainingRequest;
import com.frontbackend.springboot.service.TrainingService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/training")
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
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
    public String save(@RequestBody TrainingRequest request) {
        return trainingService.save(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody TrainingRequest request) {
        Optional<Training> training = trainingService.findById(id);
        if (training.isPresent()) {
            trainingService.update(id, request);
        } else {
            trainingService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        trainingService.delete(id);
    }
}