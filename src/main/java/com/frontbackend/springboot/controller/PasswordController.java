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

import com.frontbackend.springboot.model.Password;
import com.frontbackend.springboot.model.PasswordRequest;
import com.frontbackend.springboot.service.PasswordService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/password")
public class PasswordController {
    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }


    @PostMapping
    public String save(@RequestBody PasswordRequest request) {
        return passwordService.save(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody PasswordRequest request) {
        Optional<Password> Password = passwordService.findById(id);
        if (Password.isPresent()) {
            passwordService.update(id, request);
        } else {
            passwordService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        passwordService.delete(id);
    }
}