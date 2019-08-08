package com.codeclan.example.coursebookingservice.controllers;

import com.codeclan.example.coursebookingservice.models.Customer;
import com.codeclan.example.coursebookingservice.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/course/{courseId}")
    public List<Customer> getCustomersByCourse(@PathVariable Long courseId) {
        return customerRepository.getAllCustomersForCourse(courseId);
    }

}
