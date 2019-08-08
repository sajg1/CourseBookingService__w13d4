package com.codeclan.example.coursebookingservice;

import com.codeclan.example.coursebookingservice.models.Course;
import com.codeclan.example.coursebookingservice.repositories.CourseRepository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursebookingserviceApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createCourse() {
		Course course = new Course("Java", "Edinburgh", 1);
		courseRepository.save(course);
	}

}
