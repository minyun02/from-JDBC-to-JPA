package com.minsproject.jdbc.databasejdbc;

import com.minsproject.jdbc.databasejdbc.entity.User;
import com.minsproject.jdbc.databasejdbc.jdbc.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("사용자 10001 DELETE-> No of Rows Deleted {}", dao.deleteById(10003, "아스가르드"));
		logger.info("insert -> No of Rows Inserted {}", dao.insert(
				new User(10004,
						"캡틴",
						"미국",
						new Date())));
		logger.info("update -> {}", dao.update(
				new User(10002,
						"아이언맨사망",
						"천국",
						new Date())));
		logger.info("All Users -> {}", dao.findAll());
//		logger.info("사용자 10001 -> {}", dao.findById(10001));
//		logger.info("Location 뉴욕 -> {}", dao.findByLocation("뉴욕"));
	}
}
