package com.minsproject.jdbc.databasejdbc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    protected Course(){}// protected로 접근을 막는다.

    public Course(String name){ //파라미터가 있는 생성자를 만들면 java에서 제공하는 파라미터 없는 생성자 기능이 상실 따라서 파라미터가 없는 생성자를 따로 만들어주아야한다
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nCourse{" +
                "name='" + name + '\'' +
                '}';
    }
}
