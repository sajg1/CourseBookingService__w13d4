package com.codeclan.example.coursebookingservice.repositories.CustomerRepository;

import com.codeclan.example.coursebookingservice.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> getAllCustomersForCourse(Long courseId);
}
