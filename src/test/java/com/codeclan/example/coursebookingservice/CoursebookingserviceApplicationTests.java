package com.codeclan.example.coursebookingservice;

import com.codeclan.example.coursebookingservice.models.Booking;
import com.codeclan.example.coursebookingservice.models.Course;
import com.codeclan.example.coursebookingservice.models.Customer;
import com.codeclan.example.coursebookingservice.repositories.BookingRepository.BookingRepository;
import com.codeclan.example.coursebookingservice.repositories.CourseRepository.CourseRepository;
import com.codeclan.example.coursebookingservice.repositories.CustomerRepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursebookingserviceApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateCourse() {
		Course course = new Course("Java", "Edinburgh", 1);
		courseRepository.save(course);
	}

	@Test
	public void canCreateCustomer(){
		Customer customer = new Customer("Bob", "Edinburgh", 15);
		customerRepository.save(customer);
	}

	@Test
	public void canCreateBooking(){
		Course course = new Course("Java", "Edinburgh", 1);
		courseRepository.save(course);
		Customer customer = new Customer("Bob", "Edinburgh", 15);
		customerRepository.save(customer);
		Booking booking = new Booking("08-08-19", customer, course);
		bookingRepository.save(booking);
	}

	@Test
    public void CourseBookingListStartsEmpty() {
        Course course = new Course("Java", "Edinburgh", 1);
        courseRepository.save(course);
	    assertEquals(0, course.countBookings());
    }

    @Test
    public void CanAddBookingToCourse() {
        Course course = new Course("Java", "Edinburgh", 1);
        courseRepository.save(course);
        Customer customer = new Customer("Bob", "Edinburgh", 15);
        customerRepository.save(customer);
        Booking booking = new Booking("08-08-19", customer, course);
        bookingRepository.save(booking);
        course.addBooking(booking);
        assertEquals(1, course.countBookings());
    }

    @Test
    public void CustomerBookingListStartsEmpty() {
        Customer customer = new Customer("Bob", "Edinburgh", 15);
        customerRepository.save(customer);
        assertEquals(0, customer.countBookings());
    }

    @Test
    public void CanAddBookingToCustomer() {
        Course course = new Course("Java", "Edinburgh", 1);
        courseRepository.save(course);
        Customer customer = new Customer("Bob", "Edinburgh", 15);
        customerRepository.save(customer);
        Booking booking = new Booking("08-08-19", customer, course);
        bookingRepository.save(booking);
        customer.addBooking(booking);
        assertEquals(1, customer.countBookings());
    }

}
