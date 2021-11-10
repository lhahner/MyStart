package com.frontbackend.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frontbackend.springboot.model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, String> {

	List<Trainer> findAllByEmailContaining(String email);

}
