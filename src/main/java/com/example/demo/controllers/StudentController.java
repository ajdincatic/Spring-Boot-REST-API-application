package com.example.demo.controllers;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.requests.StudentInsertRequest;
import com.example.demo.requests.StudentSearchRequest;
import com.example.demo.services.CourseService;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/students")
    public List<Student> getAllStudents(StudentSearchRequest request){
        return studentService.getAll(request);
    }

    // same name of parameter in url and parameter
    @RequestMapping("/students/{Id}")
    public Student getStudentById(@PathVariable Long Id){
        return studentService.getById(Id);
    }

    // take from request body into course instance
    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public Student AddStudent(@RequestBody StudentInsertRequest student){
        return studentService.Insert(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students/{Id}")
    public Student UpdateStudent(@RequestBody StudentInsertRequest student, @PathVariable Long Id){
        return studentService.Update(student,Id);
    }

}

