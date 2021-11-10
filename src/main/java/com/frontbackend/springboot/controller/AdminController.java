package com.frontbackend.springboot.controller;

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

import com.frontbackend.springboot.model.Admin;
import com.frontbackend.springboot.model.AdminRequest;
import com.frontbackend.springboot.service.AdminService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Admin> admin(@PathVariable String id) {
        Optional<Admin> admin = adminService.findById(id);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public Optional<Admin> list(@RequestParam(required = false) String id) {
        if (StringUtils.isEmpty(id)) {
            return adminService.findById("1");
        }
        return adminService.findByIdentification(id);
    }

    @PostMapping
    public String save(@RequestBody AdminRequest request) {
        return adminService.save(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody AdminRequest request) {
        Optional<Admin> Admin = adminService.findById(id);
        if (Admin.isPresent()) {
            adminService.update(id, request);
        } else {
            adminService.save(request);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        adminService.delete(id);
    }
}
