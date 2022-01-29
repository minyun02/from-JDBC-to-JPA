package com.minsproject.jdbc.databasejdbc.repository;

import com.minsproject.jdbc.databasejdbc.entity.Course;
import com.minsproject.jdbc.databasejdbc.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public Course save(Course course){
        if(course.getId()==null){
            //insert
            em.persist(course);
        }else{
            //update
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course); //object entity가 매개변수로 들어가야해서 course 인스턴스 생성
    }

    public void playWithEntityManager(){
        logger.info("playWithEntityManager - start");
        Course newCourse = new Course("new course test");
        em.persist(newCourse);
        // 2.이유는 @Transactional 애너테이션이 playWithEntityManager 메서드를 하나의 트랜잭션으로 보기 때문이다.
//        Course newCourse2 = new Course("new course test2");
//        em.persist(newCourse2);
//        em.flush();
//        em.clear();
//        em.detach(newCourse2);
        Course newCourse2 = findById(10001L);
//        newCourse.setName("new course test - updated"); //1.setName을 해주기만해도 데이터베이스에 업데이트가 들어간다
        newCourse2.setName("new course test2 - updated");

//        em.refresh(newCourse);

//        em.flush();
    }

    public void addReviewsForCourse() {
        //get the course 10003
        Course course = findById(10003L);
        logger.info("course.getReviews -> {}", course.getReviews());

        //add 2 reviews to it
        Review review1 = new Review("1","very bad");
        Review review2 = new Review("3","it was ok...");

        //setting the relationship
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        //save to the database
        em.persist(review1);
        em.persist(review2);
    }
}
