package com.example.demo.services;

import com.example.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    // When instance of TopicService is created topicRepository will be injected to it
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(Long topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourseById(Long Id){
        Course t = courseRepository.findById(Id).orElse(null);
        return t;
    }

    public Course InsertCourse(Course course){
        courseRepository.save(course);
        return course;
    }

    public Course UpdateCourse(Course course) {
        // repository recognize if there is already row in table, we do not need Id
        courseRepository.save(course);
        return course;
    }

    public Course DeleteCourse(Long id) {
        Course t = getCourseById(id);
        courseRepository.deleteById(id);
        return t;
    }
}
