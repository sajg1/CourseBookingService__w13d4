package com.codeclan.example.coursebookingservice.components;

import com.codeclan.example.coursebookingservice.models.Booking;
import com.codeclan.example.coursebookingservice.models.Course;
import com.codeclan.example.coursebookingservice.models.Customer;
import com.codeclan.example.coursebookingservice.repositories.BookingRepository.BookingRepository;
import com.codeclan.example.coursebookingservice.repositories.CourseRepository.CourseRepository;
import com.codeclan.example.coursebookingservice.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Course java = new Course("Java", "Edinburgh", 1);
        courseRepository.save(java);

        Course javaScript = new Course("JavaScript", "Glasgow", 5);
        courseRepository.save(javaScript);

        Course ruby = new Course("Ruby", "Inverness", 9);
        courseRepository.save(ruby);


        Customer bob = new Customer("Bob", "Edinburgh", 15);
        customerRepository.save(bob);

        Customer joe = new Customer("Joe", "Edinburgh", 18);
        customerRepository.save(joe);

        Booking booking1 = new Booking("08-08-19", bob, java);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("20-06-19", joe, javaScript);
        bookingRepository.save(booking2);

        bob.addBooking(booking1);

    }
}
