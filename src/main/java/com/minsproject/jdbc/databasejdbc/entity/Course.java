package com.minsproject.jdbc.databasejdbc.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Course")
@NamedQuery(name = "query_get_all", query = "select c from Course c")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @UpdateTimestamp
    @Column(name = "lastUpdatedDate")
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

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

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    @Override
    public String toString() {
        return "\nCourse{" +
                "name='" + name + '\'' +
                '}';
    }
}
