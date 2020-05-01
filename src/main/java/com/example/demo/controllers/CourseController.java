package com.example.demo.controllers;

import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.services.CourseService;
import com.example.demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    // mark as dependency injection
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/courses")
    public List<Course> getAllCourses(){
        // converts to JSON automatic
        return courseService.getAllCourses();
    }

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCoursesByTopic(@PathVariable Long topicId){
        return courseService.getAllCoursesByTopic(topicId);
    }

    // same name of parameter in url and parameter
    @RequestMapping("/courses/{Id}")
    public Course getCourseById(@PathVariable Long Id){
        return courseService.getCourseById(Id);
    }

    // take from request body into course instance
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public Course AddCourse(@RequestBody Course course, @PathVariable Long topicId){
        return courseService.InsertCourse(course,topicId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{Id}")
    public Course UpdateCourse(@RequestBody @Valid Course course, @PathVariable Long topicId, @PathVariable Long Id){
        return courseService.UpdateCourse(course,topicId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{Id}")
    public Course DeleteCourse(@PathVariable Long Id){
        return courseService.DeleteCourse(Id);
    }

}
