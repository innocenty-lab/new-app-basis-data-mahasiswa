package com.enigmacamp.student;

import com.enigmacamp.student.config.BeanConfiguration;
import com.enigmacamp.student.model.Major;
import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.repository.StudentRepository;
import com.enigmacamp.student.repository.StudentRepositoryImpl;
import com.enigmacamp.student.service.StudentService;
import com.enigmacamp.student.service.StudentServiceImpl;
import com.enigmacamp.student.validation.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppStudent {
    public static void main(String[] args) {
//        StudentRepository studentRepository = new StudentRepositoryImpl(5);
//
//        // add data
//        studentRepository.add(new Student("Putra", 18, new Major("informatika")));
//        studentRepository.add(new Student("Boba", 29, new Major("Fisika")));
//        studentRepository.add(new Student("ciyo", 29, new Major("Biologi")));
//
//        // delete data
//        studentRepository.delete();
//
//        // view all data
//        System.out.println("==== View all data ====");
//        for (Student student:studentRepository.viewAll()) {
//            System.out.println(student);
//        }
//
//        // view data by id
//        System.out.println("\n==== Find by index ====");
//        Student student = studentRepository.viewByIndex(1);
//        System.out.println(student);

//      =================================================================================

//        StudentRepository studentRepository = new StudentRepositoryImpl(5);
////        Validation ageValidation = new StudentAgeValidation(17);
//        Validation ageValidation = new EmptyAgeValidation();
//        Validation nameLengthValidation = new StudentNameLengthValidation(3, 20);
//        StudentService studentService = new StudentServiceImpl(studentRepository, ageValidation, nameLengthValidation);
//
//        // add data
//        studentService.registerStudent(new Student("co", 29, new Major("Biologi")));
//        studentService.registerStudent(new Student("Putra", 18, new Major("informatika")));
//        studentService.registerStudent(new Student("Boba", 29, new Major("Fisika")));
//
//        // delete data
//        studentService.unregisterStudent();
//
//        // view all data
//        System.out.println("==== View all data ====");
//        for (Student student : studentService.getAllStudent()) {
//            System.out.println(student);
//        }
//
//        // view data by id
//        System.out.println("\n==== Find by index ====");
//        Student student = studentService.getStudentByIndex(0);
//        System.out.println(student);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanConfiguration.class);
        ctx.refresh();

        StudentService studentService = ctx.getBean(StudentService.class);
        MaxDataValidation maxDataValidation = ctx.getBean(MaxDataValidation.class);
        StudentAgeValidation studentAgeValidation = ctx.getBean(StudentAgeValidation.class);
        StudentNameLengthValidation studentNameLengthValidation = ctx.getBean(StudentNameLengthValidation.class);

        maxDataValidation.setMaxData(3);
        studentAgeValidation.setMinAge(17);
        studentNameLengthValidation.setMinLen(6);
        studentNameLengthValidation.setMaxLen(10);

        studentService.registerStudent(new Student("hadid", 29, new Major("Biologi")));
        studentService.registerStudent(new Student("Putraa", 18, new Major("informatika")));
        studentService.registerStudent(new Student("Boba", 29, new Major("Fisika")));

        for (Student s:studentService.getAllStudent()) {
            System.out.println(s);
        }

    }
}
