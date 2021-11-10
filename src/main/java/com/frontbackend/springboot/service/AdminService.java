package com.frontbackend.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontbackend.springboot.model.Admin;
import com.frontbackend.springboot.model.AdminRequest;
import com.frontbackend.springboot.repository.AdminRepository;

@Service
public class AdminService {
	private final AdminRepository adminRepository;

	@Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

	public Optional<Admin> findById(String id) {
		return adminRepository.findById(id);
	}

	public String save(AdminRequest request) {
		Admin admin = new Admin();
		admin.setAdmin_id(request.getAdmin_id());
		admin.setFirst_name(request.getFirst_name());
		admin.setLast_name(request.getLast_name());
		
		return adminRepository.save(admin).getAdmin_id();
	}

	public void update(String id, AdminRequest request) {
		Optional<Admin> admin = findById(id);
		if (admin.isPresent()) {
			Admin forUpdate = admin.get();
			forUpdate.setAdmin_id(request.getAdmin_id());
			forUpdate.setFirst_name(request.getFirst_name());
			forUpdate.setLast_name(request.getLast_name());
			adminRepository.save(forUpdate);
		}
	}

	@Transactional
	public List<Admin> getAll() {
		return adminRepository.findAll();
	}

	public Optional<Admin> findByIdentification(String id) {
		return adminRepository.findById(id);
	}

	public void delete(String id) {
		Optional<Admin> admin = findById(id);
		admin.ifPresent(adminRepository::delete);
	}
}
