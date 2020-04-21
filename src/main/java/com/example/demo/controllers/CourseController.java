package com.example.demo.controllers;

import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    // mark as dependency injection
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/topics/{Id}/courses") // just for get
    public List<Course> getAllcourses(@PathVariable Long Id){
        // converts to JSON automatic
        return courseService.getAllCourses(Id);
    }

    // same name of parameter in url and parameter
    @RequestMapping("/topics/{topicId}/courses/{Id}")
    public Course getCourseById(@PathVariable Long Id){
        return courseService.getCourseById(Id);
    }

    // take from request body into course instance
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public Course AddCourse(@RequestBody Course course, @PathVariable Long topicId){
        course.setTopic(new Topic(topicId,"",""));
        return courseService.InsertCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{Id}")
    public Course UpdateCourse(@RequestBody Course course, @PathVariable Long topicId, @PathVariable Long Id){
        course.setTopic(new Topic(topicId,"",""));
        return courseService.UpdateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{Id}")
    public Course DeleteCourse(@PathVariable Long Id){
        return courseService.DeleteCourse(Id);
    }

}
