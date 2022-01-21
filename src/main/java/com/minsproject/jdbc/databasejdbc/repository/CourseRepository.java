package com.minsproject.jdbc.databasejdbc.repository;

import com.minsproject.jdbc.databasejdbc.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

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
}
