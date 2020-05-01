package com.example.demo.services;

import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    // When instance of TopicService is created topicRepository will be injected to it
    private CourseRepository courseRepository;
    private TopicRepository topicRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, TopicRepository topicRepository) {
        this.courseRepository = courseRepository;
        this.topicRepository = topicRepository;
    }

    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public List<Course> getAllCoursesByTopic(Long topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourseById(Long Id){
        Course t = courseRepository.findById(Id).orElse(null);
        return t;
    }

    public Course InsertCourse(Course course, Long topicId){
        Optional<Topic> t = topicRepository.findById(topicId);
        course.setTopic(t.get());
        courseRepository.save(course);
        return course;
    }

    public Course UpdateCourse(Course course, Long topicId) {
        Optional<Topic> t = topicRepository.findById(topicId);
        course.setTopic(t.get());
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
