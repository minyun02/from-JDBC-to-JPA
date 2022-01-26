package com.minsproject.jdbc.databasejdbc;

import com.minsproject.jdbc.databasejdbc.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DatabaseJPAApplication.class)
class NativeQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void native_query_with_parameters() {
		Query q = em.createNativeQuery("Select * from course where id = ?", Course.class);
		q.setParameter(1, 10001L);
		List result = q.getResultList();
		logger.info("Select * from where id = ? -> {}", result);
	}

	@Test
	public void native_query_with_named_parameters() {
		Query q = em.createNativeQuery("Select * from course where id = :id", Course.class);
		q.setParameter("id", 10001L);
		List result = q.getResultList();
		logger.info("Select * from where id=? -> {}", result);
	}
}
