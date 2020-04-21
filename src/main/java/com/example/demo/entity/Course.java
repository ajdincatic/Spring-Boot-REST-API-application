package com.example.demo.entity;

import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

// make Topic as table
@Entity
public class Course {

    // use lowercase letters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Course() {
    }

    public Course(Long id, String name, String description,Long topicId) {
        name = name;
        id = id;
        description = description;
        topic = new Topic(topicId,"","");
    }

}

