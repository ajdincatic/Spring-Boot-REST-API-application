package com.example.demo.services;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Topic;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TopicRepository;
import com.example.demo.requests.StudentInsertRequest;
import com.example.demo.requests.StudentSearchRequest;
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

    public List<Student> getAll(StudentSearchRequest request){
        List<Student> courses = new ArrayList<>();

        if(request.lastName != null){
            studentRepository.findByLastName(request.lastName).forEach(courses::add);
        }
        if(request.courseId != null){
            studentRepository.findByCourseId(request.courseId).forEach(courses::add);
        }
        else {
            studentRepository.findAll().forEach(courses::add);
        }
        return courses;
    }

    public Student getById(Long Id){
        Student t = studentRepository.findById(Id).orElse(null);
        return t;
    }

    public Student Insert(StudentInsertRequest student){
        Student s = new Student();
        s.setFirstName(student.firstName);
        s.setLastName(student.lastName);
        s.setCourse(courseRepository.findById(student.courseId).get());
        studentRepository.save(s);
        return s;
    }

    public Student Update(StudentInsertRequest student,Long Id) {
        Student s = studentRepository.findById(Id).get();
        s.setFirstName(student.firstName);
        s.setLastName(student.lastName);
        s.setCourse(courseRepository.findById(student.courseId).get());
        studentRepository.save(s);
        return s;
    }
}
