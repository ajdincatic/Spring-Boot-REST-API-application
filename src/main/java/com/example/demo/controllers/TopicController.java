package com.example.demo.controllers;

import com.example.demo.models.Topic;
import com.example.demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicController {

    // mark as dependency injection
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics") // just for get
    public List<Topic> getAllTopics(){
        // converts to JSON automatic
        return topicService.getAllTopics();
    }

    // same name of parameter in url and parameter
    @RequestMapping("/topics/{Id}")
    public Topic getTopicById(@PathVariable String Id){
        return topicService.getTopicById(Id);
    }

    // take from request body into Topic instance
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public Topic AddTopic(@RequestBody Topic topic){
        return topicService.InsertTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{Id}")
    public Topic UpdateTopic(@RequestBody Topic topic,@PathVariable String Id){
        return topicService.UpdateTopic(Id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{Id}")
    public Topic DeleteTopic(@PathVariable String Id){
        return topicService.DeleteTopic(Id);
    }

}
