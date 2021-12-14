package com.netcracker.accountingofstudents;

import com.netcracker.accountingofstudents.Students.Repository.StudentsRepository;
import com.netcracker.accountingofstudents.Students.Students;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.netcracker")
public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        StudentsRepository studentsRepository = applicationContext.getBean(StudentsRepository.class);


    }
}
