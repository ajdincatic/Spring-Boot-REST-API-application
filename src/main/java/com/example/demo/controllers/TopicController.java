package com.example.demo.controllers;

import com.example.demo.entity.Topic;
import com.example.demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    // mark as dependency injection
    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("/topics")
    //@GetMapping same
    public List<Topic> getAllTopics(){
        // converts to JSON automatic
        return topicService.getAllTopics();
    }

    // same name of parameter in url and parameter
    @RequestMapping("/topics/{Id}")
    public Topic getTopicById(@PathVariable Long Id){
        return topicService.getTopicById(Id);
    }

    // take from request body into Topic instance
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public Topic AddTopic(@RequestBody Topic topic){
        return topicService.InsertTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{Id}")
    public Topic UpdateTopic(@RequestBody Topic topic,@PathVariable Long Id){
        return topicService.UpdateTopic(Id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{Id}")
    public Topic DeleteTopic(@PathVariable Long Id){
        return topicService.DeleteTopic(Id);
    }

}
