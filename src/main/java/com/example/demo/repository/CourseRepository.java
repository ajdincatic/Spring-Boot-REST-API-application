package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    // CrudRepository implements all crud operations by default

    // automatic implementation for methods
    public List<Course> findByName(String name);
    // findBy/*PropertyName*//*FieldName in that object*/
    public List<Course> findByTopicId(Long Id);
}
