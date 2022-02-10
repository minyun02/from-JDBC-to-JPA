package com.minsproject.jdbc.databasejdbc;

import com.minsproject.jdbc.databasejdbc.entity.*;
import com.minsproject.jdbc.databasejdbc.repository.CourseRepository;
import com.minsproject.jdbc.databasejdbc.repository.EmployeeRepository;
import com.minsproject.jdbc.databasejdbc.repository.StudentRepository;
import com.minsproject.jdbc.databasejdbc.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DatabaseJPAApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserJpaRepository repository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseJPAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		employeeRepository.insert(new PartTimeEmployee("Park", new BigDecimal("20")));
//		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//		Student student = new Student("ME");
//		Course course = new Course("ME COURSE TEST");
//		studentRepository.insertStudentAndCourse(student, course);
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("1","very bad"));
//		reviews.add(new Review("3","it was ok..."));
//		courseRepository.addReviewsForCourse(10003L, reviews);
//		courseRepository.addHardCodedReviewsForCourse();

//		courseRepository.playWithEntityManager();
//		studentRepository.saveStudentWithPassport();
//		Course course = courseRepository.findById(10001L);

//		courseRepository.deleteById(10001L); //void 메서드기때문에 로그를 찍을 수 없다.
//
//		logger.info("Course 10001 -> {}", course);
//		courseRepository.save(new Course("Microservices in 100 steps"));
//		logger.info("사용자 10001 -> {}", repository.findById(10001));
//		logger.info("insert -> No of Rows Inserted {}", repository.merge(
//				new User(
//						"캡틴",
//						"미국",
//						new Date())));
//		logger.info("update -> {}", repository.merge(
//				new User(10002,
//						"아이언맨사망",
//						"천국",
//						new Date())));
//		repository.deletById(10002);
//		logger.info("All Users -> {}", repository.findAll());
	}
}
