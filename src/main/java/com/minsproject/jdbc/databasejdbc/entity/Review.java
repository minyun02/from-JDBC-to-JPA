package com.minsproject.jdbc.databasejdbc.entity;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    private String description;

    protected Review(){}// protected로 접근을 막는다.

    public Review(String rating, String description){ //파라미터가 있는 생성자를 만들면 java에서 제공하는 파라미터 없는 생성자 기능이 상실 따라서 파라미터가 없는 생성자를 따로 만들어주아야한다
        this.rating = rating;
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nReview{" +
                "rating='" + rating + '\'' +
                "description='" + description + '\'' +
                '}';
    }
}
