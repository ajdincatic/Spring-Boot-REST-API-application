package com.example.demo.services;

import com.example.demo.models.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    // just one instance of List of Topic
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("111","Topic1","DescriptionTopic1"),
            new Topic("112","Topic2","DescriptionTopic2"),
            new Topic("113","Topic3","DescriptionTopic3"),
            new Topic("114","Topic4","DescriptionTopic4"),
            new Topic("115","Topic5","DescriptionTopic5")
    ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopicById(String Id){
        return topics.stream().filter(x -> x.getId().equals(Id)).findFirst().get();
    }

    public Topic InsertTopic(Topic topic){
        topics.add(topic);
        return topic;
    }

    public Topic UpdateTopic(String Id, Topic topic) {
        for (int i = 0; i < topics.size(); i++){
            if(topics.get(i).getId().equals(Id)){
                Topic newTopic = topics.set(i, topic);
                return newTopic;
            }
        }
        return null;
    }

    public Topic DeleteTopic(String id) {
        Topic t = getTopicById(id);
        topics.removeIf(x -> x.getId().equals(id));
        return t;
    }
}
