package com.example.demo.services;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Topic;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(CourseRepository courseRepository,StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll(){
        List<Student> courses = new ArrayList<>();
        studentRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Student getById(Long Id){
        Student t = studentRepository.findById(Id).orElse(null);
        return t;
    }

    @Transactional
    public Student Insert(Student student, Long courseId){
        Optional<Course> t = courseRepository.findById(courseId);
        student.setCourse(t.get());
        studentRepository.save(student);
        return student;
    }

    public Student Update(Student student, Long courseId) {
        Optional<Course> t = courseRepository.findById(courseId);
        student.setCourse(t.get());
        // repository recognize if there is already row in table, we do not need Id
        studentRepository.save(student);
        return student;
    }
}
