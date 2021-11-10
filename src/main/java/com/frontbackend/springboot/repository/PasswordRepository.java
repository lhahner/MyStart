package com.frontbackend.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frontbackend.springboot.model.Password;

@Repository
public interface PasswordRepository extends JpaRepository<Password, String> {
	
	List<Password> findAllByGroupnameContaining(String groupname);
	
}