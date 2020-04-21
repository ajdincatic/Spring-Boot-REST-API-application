package com.example.demo.entity;

import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// make Topic as table
@Entity
public class Course {

    // use lowercase letters for property names
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NotNull
    @Size(min = 1,message = "Description must not be empty")
    private String description;

    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(Long id, String name, String description,Long topicId) {
        name = name;
        description = description;
        topic = new Topic(topicId,"","");
    }

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


}

