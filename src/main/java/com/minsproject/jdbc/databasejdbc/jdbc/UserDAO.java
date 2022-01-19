package com.minsproject.jdbc.databasejdbc.jdbc;

import com.minsproject.jdbc.databasejdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    JdbcTemplate template;

    class UserRowMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setLocation(rs.getString("location"));
            user.setBirthDate(rs.getTimestamp("birth_date"));
            return user;
        }
    }

    public List<User> findAll(){
        return template.query("select * from user",
                new BeanPropertyRowMapper<>(User.class));
    }

    public User findById(int id){
        return template.queryForObject("select * from user where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<User>(User.class));
    }

    public List<User> findByLocation(String location){
        return template.query("select * from user where location=?",
                new Object[]{location},
                new BeanPropertyRowMapper<User>(User.class));
    }

    public int deleteById(int id, String location){
        return template.update("delete from user where id=? and location=?",
                new Object[]{id, location});
    }

    public int insert(User user){
        return template.update("insert into user (id, name, location, birth_date)" +
                        "values(?, ?, ?, ?)",
                new Object[]{
                        user.getId(), user.getName(),
                        user.getLocation(),
                        new Timestamp(user.getBirthDate().getTime())
                });
    }

    public int update(User user){
        return template.update("update user" +
                        " set name = ?, location = ?, birth_date = ?" +
                        " where id = ?",
                new Object[]{
                        user.getName(),
                        user.getLocation(),
                        new Timestamp(user.getBirthDate().getTime()),
                        user.getId(),
                });
    }
}
