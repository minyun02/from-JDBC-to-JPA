package com.minsproject.jdbc.databasejdbc.repository;

import com.minsproject.jdbc.databasejdbc.entity.Course;
import com.minsproject.jdbc.databasejdbc.entity.Employee;
import com.minsproject.jdbc.databasejdbc.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    //insert an employee
    public void insert(Employee employee){
        em.persist(employee);
    }
    //retrieve all employee
    public List<Employee> retrieveAllEmployee(){
        return em.createQuery("select e from employee e",Employee.class).getResultList();
    }


}
