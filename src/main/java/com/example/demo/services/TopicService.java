package com.example.demo.services;

import com.example.demo.entity.Topic;
import com.example.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    // When instance of TopicService is created topicRepository will be injected to it
    private TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        //topicRepository.findAll().forEach(x -> topics.add(x)); same
        return topics;
    }

    public Topic getTopicById(Long Id){
        return topicRepository.findById(Id).orElse(null);
    }

    public Topic InsertTopic(Topic topic){
        topicRepository.save(topic);
        return topic;
    }

    public Topic UpdateTopic(Long Id, Topic topic) {
        // repository recognize if there is already row in table, we do not need Id
        topicRepository.save(topic);
        return topic;
    }

    public Topic DeleteTopic(Long id) {
        Topic t = getTopicById(id);
        topicRepository.deleteById(id);
        return t;
    }
}
