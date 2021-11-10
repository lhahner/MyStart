package com.frontbackend.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontbackend.springboot.model.Trainer;
import com.frontbackend.springboot.model.TrainerRequest;
import com.frontbackend.springboot.repository.TrainerRepository;

@Service
public class TrainerService {

	private final TrainerRepository trainerRepository;

	@Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

	public Optional<Trainer> findById(String id) {
		return trainerRepository.findById(id);
	}

	public String save(TrainerRequest request) {
		Trainer trainer = new Trainer();
		trainer.setEmail(request.getEmail());
		trainer.setJob_title(request.getJob_title());
		trainer.setFirst_name(request.getFirst_name());
		trainer.setLast_name(request.getLast_name());
		trainer.setlinkedin_link(request.getlinkedin_link());
		trainer.setProfile_pic(request.getProfile_pic());
		trainer.setTelephone(request.getTelephone());
		trainer.setTopics(request.getTopics());
		
		return trainerRepository.save(trainer).getTrainer_id();
	}

	public void update(String id, TrainerRequest request) {
		Optional<Trainer> trainer = findById(id);
		if (trainer.isPresent()) {
			Trainer forUpdate = trainer.get();
			forUpdate.setEmail(request.getEmail());
			forUpdate.setFirst_name(request.getFirst_name());
			forUpdate.setLast_name(request.getLast_name());
			forUpdate.setJob_title(request.getJob_title());
			forUpdate.setlinkedin_link(request.getlinkedin_link());
			forUpdate.setProfile_pic(request.getProfile_pic());
			forUpdate.setTelephone(request.getTelephone());
			forUpdate.setTopics(request.getTopics());
			trainerRepository.save(forUpdate);
		}
	}

	@Transactional
	public List<Trainer> getAll() {
		return trainerRepository.findAll();
	}

	public List<Trainer> findByEmail(String email) {
		return trainerRepository.findAllByEmailContaining(email);
	}

	public void delete(String id) {
		Optional<Trainer> trainer = findById(id);
		trainer.ifPresent(trainerRepository::delete);
	}
}
