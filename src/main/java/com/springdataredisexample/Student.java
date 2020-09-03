package com.springdataredisexample;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/*
Student entity
 */
@RedisHash("Student")
@Data
public class Student implements Serializable {
    public enum Gender {MALE, FEMALE};

    private String id;
    private String name;
    private int grade;

    public Student(String id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
