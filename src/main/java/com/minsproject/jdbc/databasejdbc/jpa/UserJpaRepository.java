package com.minsproject.jdbc.databasejdbc.jpa;


import com.minsproject.jdbc.databasejdbc.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
//Repository
//Transaction
public class UserJpaRepository {

    //connect to the database
    @PersistenceContext
    EntityManager entityManager;

    public List<User> findAll(){
        TypedQuery<User> namedQuery = entityManager.createNamedQuery("find_all_users", User.class);
        return namedQuery.getResultList();
    }

    public User findById(int id){
        return entityManager.find(User.class, id);//JPA
    }

    public User merge(User user){
        return entityManager.merge(user);
    }

    public void deletById(int id){
        User user = findById(id);
        entityManager.remove(user);
    }
}
