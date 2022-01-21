package com.minsproject.jdbc.databasejdbc;

import com.minsproject.jdbc.databasejdbc.entity.Course;
import com.minsproject.jdbc.databasejdbc.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DatabaseJPAApplication.class)
class DatabaseJPAApplicationTests {

	@Autowired
	CourseRepository repository;

	@Test
	public void findById_basics() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
	}

}
