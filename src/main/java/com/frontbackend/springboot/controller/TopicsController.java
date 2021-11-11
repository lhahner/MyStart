package com.frontbackend.springboot.controller;

import com.frontbackend.springboot.model.Admin;
import com.frontbackend.springboot.model.AdminRequest;
import com.frontbackend.springboot.model.Topics;
import com.frontbackend.springboot.model.TopicsRequest;
import com.frontbackend.springboot.service.AdminService;
import com.frontbackend.springboot.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/topics")
public class TopicsController {
	private final TopicsService topicsService;

    @Autowired
    public TopicsController(TopicsService topicsService) {
        this.topicsService = topicsService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Topics> topic(@PathVariable String id) {
        Optional<Topics> topic = topicsService.findById(id);
        return topic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Topics> list(@RequestParam(required = false) String id) {
            return topicsService.getAll();

    }

    @PostMapping
    public String save(@RequestBody TopicsRequest request) {
        return topicsService.save(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody TopicsRequest request) {
        Optional<Topics> topic = topicsService.findById(id);
        if (topic.isPresent()) {
            topicsService.update(id, request);
        } else {
            topicsService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        topicsService.delete(id);
    }
}
