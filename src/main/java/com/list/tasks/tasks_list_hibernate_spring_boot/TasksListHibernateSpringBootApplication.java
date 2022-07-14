package com.list.tasks.tasks_list_hibernate_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TasksListHibernateSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasksListHibernateSpringBootApplication.class, args);

//        LocalDate date = LocalDate.now();
//
//        System.out.println(date);


    }

    @Bean
    public BCryptPasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }

}
