package com.frontbackend.springboot.repository;

import com.frontbackend.springboot.model.Admin;
import com.frontbackend.springboot.model.Topics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicsRepository extends JpaRepository<Topics, String> {
	
	Optional<Topics> findById(String id);
	
}
