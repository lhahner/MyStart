package com.frontbackend.springboot.service;


import com.frontbackend.springboot.model.Topics;
import com.frontbackend.springboot.model.TopicsRequest;
import com.frontbackend.springboot.model.Trainer;
import com.frontbackend.springboot.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TopicsService {
	private final TopicsRepository topicsRepository;

	@Autowired
    public TopicsService(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }



	public Optional<Topics> findById(String id) {
		return topicsRepository.findById(id);
	}

	public String save(TopicsRequest request) {
		Topics topic = new Topics();
		topic.setTopicId(request.getTopicsid());
		topic.setTopicInfo(request.getTopicsinfo());
		return topicsRepository.save(topic).getTopicId();
	}

	public void update(String id, TopicsRequest request) {
		Optional<Topics> topic = findById(id);
		if (topic.isPresent()) {
			Topics forUpdate = topic.get();
			forUpdate.setTopicId(request.getTopicsid());
			forUpdate.setTopicInfo(request.getTopicsinfo());
			topicsRepository.save(forUpdate);
		}
	}

	@Transactional
	public List<Topics> getAll() {
		return topicsRepository.findAll();
	}


	public void delete(String id) {
		Optional<Topics> topic = findById(id);
		topic.ifPresent(topicsRepository::delete);
	}
}
