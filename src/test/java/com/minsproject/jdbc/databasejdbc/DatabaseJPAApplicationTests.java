package com.minsproject.jdbc.databasejdbc;

import com.minsproject.jdbc.databasejdbc.entity.Course;
import com.minsproject.jdbc.databasejdbc.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DatabaseJPAApplication.class)
class DatabaseJPAApplicationTests {

	@Autowired
	CourseRepository repository;

	@Test
	public void findById_basics() {
		Course course = repository.findById(10002L);
		assertEquals("Spring in 50 steps", course.getName());
	}

	@Test
	@DirtiesContext // 데이터를 지우는 테스트기때문에 애너테이션을 추가해서 테스트가 종료되면 리셋
	public void deleteById_basics() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}

	@Test
	@DirtiesContext // 데이터를 지우는 테스트기때문에 애너테이션을 추가해서 테스트가 종료되면 리셋
	public void save_basics() {
		//get the course
		Course course = repository.findById(10002L);
		assertEquals("Spring in 50 steps", course.getName());

		//update details
		course.setName("Spring in 50 steps - updated");
		repository.save(course);

		//check the value
		Course course1 = repository.findById(10001L);
		assertEquals("Spring in 50 steps - updated", course.getName());
	}
}
