package com.enigmacamp.student.config;

import com.enigmacamp.student.repository.StudentRepository;
import com.enigmacamp.student.repository.StudentRepositoryImpl;
import com.enigmacamp.student.service.StudentService;
import com.enigmacamp.student.service.StudentServiceImpl;
import com.enigmacamp.student.validation.EmptyAgeValidation;
import com.enigmacamp.student.validation.MaxDataValidation;
import com.enigmacamp.student.validation.StudentAgeValidation;
import com.enigmacamp.student.validation.StudentNameLengthValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public StudentRepository getStudentRepository() {
        return new StudentRepositoryImpl();
    }

    @Bean
    public StudentService getStudentService() {
        return new StudentServiceImpl(getStudentRepository());
    }

    @Bean
    public MaxDataValidation setMaxDataValidation() {
        return new MaxDataValidation();
    }

    @Bean
    public StudentAgeValidation setStudentAgeValidation() {
        return new StudentAgeValidation();
    }

    @Bean
    public StudentNameLengthValidation setStudentNameLengthValidation() {
        return new StudentNameLengthValidation();
    }
}
