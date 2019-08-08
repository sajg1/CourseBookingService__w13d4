package com.codeclan.example.coursebookingservice.repositories.CourseRepository;

import com.codeclan.example.coursebookingservice.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {
    List<Course> getAllCoursesForCustomer(Long customerId);
}
