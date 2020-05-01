package com.example.demo.requests;

import javax.validation.constraints.NotBlank;

public class StudentSearchRequest {
    public String lastName;
    public Long courseId;

    public StudentSearchRequest() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
