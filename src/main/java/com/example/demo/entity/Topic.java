package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// make Topic as table
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public Topic() {
    }

    public Topic(Long id,String name, String description) {
        id = id;
        name = name;
        description = description;
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
}

