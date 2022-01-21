package com.minsproject.jdbc.databasejdbc.repository;

import com.minsproject.jdbc.databasejdbc.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    //public Course save(Course course)

    //public Course deleteById(Long id)
}
