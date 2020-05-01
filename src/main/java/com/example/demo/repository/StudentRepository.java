package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByLastName(String name);
    List<Student> findByCourseId(Long Id);
}
