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

import com.frontbackend.springboot.model.Trainer;
import com.frontbackend.springboot.model.TrainerRequest;
import com.frontbackend.springboot.service.TrainerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/trainer")
public class TrainerController {
	private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Trainer> trainer(@PathVariable String id) {
        Optional<Trainer> trainer = trainerService.findById(id);
        return trainer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Trainer> list(@RequestParam(required = false) String email) {
        if (StringUtils.isEmpty(email)) {
            return trainerService.getAll();
        }
        return trainerService.findByEmail(email); 
    }

    @PostMapping
    public String save(@RequestBody TrainerRequest request) {
        return trainerService.save(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody TrainerRequest request) {
        Optional<Trainer> Trainer = trainerService.findById(id);
        if (Trainer.isPresent()) {
            trainerService.update(id, request);
        } else {
            trainerService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        trainerService.delete(id);
    }
}
