package com.example.demo.services;

import com.example.demo.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository                                 // Table name, Id Type
public interface TopicRepository extends CrudRepository<Topic, Long> {
    // CrudRepository implements all crud operations by default

}
