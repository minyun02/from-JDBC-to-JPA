package com.minsproject.jdbc.databasejdbc;

import com.minsproject.jdbc.databasejdbc.entity.Course;
import com.minsproject.jdbc.databasejdbc.entity.Student;
import com.minsproject.jdbc.databasejdbc.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DatabaseJPAApplication.class)
class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void jpql_basics() {
//		Query q = em.createQuery("select c from Course c");
		Query q = em.createNamedQuery("query_get_all");
		List result = q.getResultList();
		logger.info("select c from Course c -> {}", result);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> tq = em.createQuery("select c from Course c", Course.class);
		List<Course> result = tq.getResultList();
		logger.info("select c from Course c -> {}", result);
	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> tq =
				em.createQuery("select c from Course c where name like '%100 steps'", Course.class);
		List<Course> result = tq.getResultList();
		logger.info("select c from Course c where name like '%100 steps'-> {}", result);
	}

	@Test
	public void jpql_courses_without_students() {
		TypedQuery<Course> tq =
				em.createQuery("select c from Course c where c.students is empty", Course.class);
		List<Course> result = tq.getResultList();
		logger.info("results -> {}", result);
	}

	@Test
	public void jpql_courses_atleast_2_students() {
		TypedQuery<Course> tq =
				em.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> result = tq.getResultList();
		logger.info("results -> {}", result);
	}

	@Test
	public void jpql_courses_ordered_by_students() {
		TypedQuery<Course> tq =
				em.createQuery("select c from Course c order by size(c.students)", Course.class);
		List<Course> result = tq.getResultList();
		logger.info("results -> {}", result);
	}

	@Test
	public void jpql_passports_in_certain_pattern() {
		TypedQuery<Student> tq =
				em.createQuery("select s from Student s where s.passport.number like '%1%'", Student.class);
		List<Student> result = tq.getResultList();
		logger.info("results -> {}", result);
	}

	@Test
	public void join() {
		 Query query =
				em.createQuery("select c, s from Course c JOIN c.students s");
		List<Object[]> result = query.getResultList();
		logger.info("results size -> {}", result.size());
		for(Object[] str : result){
			logger.info("Course{}, Students{}", str[0], str[1]);
		}
	}

	@Test
	public void left_join() {
		Query query =
				em.createQuery("select c, s from Course c LEFT JOIN c.students s");
		List<Object[]> result = query.getResultList();
		logger.info("results size -> {}", result.size());
		for(Object[] str : result){
			logger.info("Course{}, Students{}", str[0], str[1]);
		}
	}

	@Test
	public void cross_join() {
		Query query =
				em.createQuery("select c, s from Course c, Student s");
		List<Object[]> result = query.getResultList();
		logger.info("results size -> {}", result.size());
		for(Object[] str : result){
			logger.info("Course{}, Students{}", str[0], str[1]);
		}
	}
}
