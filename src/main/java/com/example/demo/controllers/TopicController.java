package com.example.demo.controllers;

import com.example.demo.models.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        // converts to JSON automatic
        return Arrays.asList(
                new Topic("111","Topic1","DescriptionTopic1"),
                new Topic("112","Topic2","DescriptionTopic2"),
                new Topic("113","Topic3","DescriptionTopic3"),
                new Topic("114","Topic4","DescriptionTopic4")
        );
    }
}
