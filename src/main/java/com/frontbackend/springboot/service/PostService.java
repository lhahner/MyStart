package com.frontbackend.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.frontbackend.springboot.model.Post;
import com.frontbackend.springboot.model.PostRequest;
import com.frontbackend.springboot.repository.PostRepository;

@Service
public class PostService {

     private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findById(String id) {
        return postRepository.findById(id);
    }

    public String save(PostRequest request) {
        Post post = new Post();
        post.setAdmin_ks(request.getAdmin_ks());
        post.setEnd_time(request.getEnd_time());
        post.setStart_time(request.getStart_time());
        post.setTopic(request.getTopic());
        post.setTrainer(request.getTrainer());
        post.setTraining_date(request.getTraining_date());

        return postRepository.save(post).getTrainingID();
        
        
       
    }

    public void update(String id, PostRequest request) {
        Optional<Post> post = findById(id);
        if (post.isPresent()) {
            Post forUpdate = post.get();
            forUpdate.setTopic(request.getTopic());
            forUpdate.setStart_time(request.getStart_time());
            forUpdate.setEnd_time(request.getEnd_time());
            forUpdate.setTrainer(request.getTrainer());
            forUpdate.setTraining_date(request.getTraining_date());
            postRepository.save(forUpdate);
        }
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public List<Post> findByTitle(String topic) {
        return postRepository.findAllByTopicContaining(topic);
    }

    public void delete(String id) {
        Optional<Post> post = findById(id);
        post.ifPresent(postRepository::delete);
    }




}