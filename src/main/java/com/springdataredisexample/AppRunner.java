package com.springdataredisexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    StudentRepository studentRepository;

    /*
    In Redis Client, How to check these data:

    127.0.0.1:6379> Keys Stude*
    STUDENT
    STUDENT:STD124
    STUDENT:STD123

    redis 127.0.0.1:6379> hgetall Student:STD124
1) "_class"
2) "com.springdataredisexample.Student"
3) "id"
4) "STD124"
5) "name"
6) "Dinesh"
7) "grade"
8) "10"
redis 127.0.0.1:6379> hgetall Student
(error) ERR Operation against a key holding the wrong kind of value
redis 127.0.0.1:6379> hgetall Student:STD123
1) "_class"
2) "com.springdataredisexample.Student"
3) "id"
4) "STD123"
5) "name"
6) "Dinesh"
7) "grade"
8) "10"

     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student st = new Student("STD124", "Dinesh", 10);
        studentRepository.save(st);
        /*Optional<Student> st = studentRepository.findById("STD123");
        if(st.isPresent())
            System.out.println(st.get().getName()+" "+st.get().getGrade()+" "+st.get());*/
    }
}
