package com.codeclan.example.coursebookingservice.controllers;

import com.codeclan.example.coursebookingservice.models.Course;
import com.codeclan.example.coursebookingservice.repositories.CourseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/rating/{rating}")
    public List<Course> getCoursesByRating(@PathVariable int rating){
        return courseRepository.findCoursesByRating(rating);
    }

    @GetMapping(value = "/customer/{customerId}")
    public List<Course> getCoursesByCustomer(@PathVariable Long customerId){
        return courseRepository.getAllCoursesForCustomer(customerId);
    }
}
