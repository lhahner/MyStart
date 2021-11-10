package com.frontbackend.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frontbackend.springboot.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
	Optional<Admin> findById(String id);
	
}
