package com.minsproject.jdbc.databasejdbc.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")//mappedBy = "변수명"
    private Student student;

    protected Passport(){}// protected로 접근을 막는다.

    public Passport(String number){ //파라미터가 있는 생성자를 만들면 java에서 제공하는 파라미터 없는 생성자 기능이 상실 따라서 파라미터가 없는 생성자를 따로 만들어주아야한다
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "number='" + number + '\'' +
                '}';
    }
}
