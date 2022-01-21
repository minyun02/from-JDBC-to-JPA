package com.minsproject.jdbc.databasejdbc;

import com.minsproject.jdbc.databasejdbc.entity.Course;
import com.minsproject.jdbc.databasejdbc.entity.User;
import com.minsproject.jdbc.databasejdbc.repository.CourseRepository;
import com.minsproject.jdbc.databasejdbc.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseJPAApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserJpaRepository repository;
	
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseJPAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(10001L);

		logger.info("Course 10001 -> {}", course);
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