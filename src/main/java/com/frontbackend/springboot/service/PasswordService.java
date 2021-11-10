package com.frontbackend.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontbackend.springboot.model.Password;
import com.frontbackend.springboot.model.PasswordRequest;
import com.frontbackend.springboot.repository.PasswordRepository;

@Service
public class PasswordService {

	private static PasswordRepository passwordRepository;

	@Autowired
    public PasswordService(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }

	public Optional<Password> findById(String id) {
		return passwordRepository.findById(id);
	}

	public String save(PasswordRequest request) {
		Password password = new Password();
		password.setGroupname(request.getGroupname());
		password.setPw(request.getPw());
		
		return passwordRepository.save(password).getGroupid();
	}

	public void update(String id, PasswordRequest request) {
		Optional<Password> password = findById(id);
		if (password.isPresent()) {
			Password forUpdate = password.get();
			forUpdate.setGroupname(request.getGroupname());
			forUpdate.setPw(request.getPw());
			passwordRepository.save(forUpdate);
		}
	}

	@Transactional
	public List<Password> getAll() {
		return passwordRepository.findAll();
	}

	public static List<Password> findByGroupname(String groupname) {
		return passwordRepository.findAllByGroupnameContaining(groupname);
	}

	public void delete(String id) {
		Optional<Password> password = findById(id);
		password.ifPresent(passwordRepository::delete);
	}
}
