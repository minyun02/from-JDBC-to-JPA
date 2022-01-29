package com.minsproject.jdbc.databasejdbc.repository;

import com.minsproject.jdbc.databasejdbc.entity.Passport;
import com.minsproject.jdbc.databasejdbc.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class, id);
    }

    public Student save(Student student){
        if(student.getId()==null){
            //insert
            em.persist(student);
        }else{
            //update
            em.merge(student);
        }
        return student;
    }

    public void deleteById(Long id){
        Student student = findById(id);
        em.remove(student); //object entity가 매개변수로 들어가야해서 student 인스턴스 생성
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("D");
        student.setPassport(passport);
        em.persist(student);
    }

    public void someOperationToUnderstandPersistenceContext() {
        //Database Operation 1 - Retrieve student
        Student student = em.find(Student.class, 20001L);
        //Persistence Context (student)


        //Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();
        //Persistence Context (student, passport)

        //Database Operation 3 - update passport
        passport.setNumber("E123457");
        //Persistence Context (student, passport++)

        //Database Operation 4 - update student
        student.setName("Ranga - updated");
        //Persistence Context (student++ , passport++)
    }
}
