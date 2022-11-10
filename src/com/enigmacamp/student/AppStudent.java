package com.enigmacamp.student;

import com.enigmacamp.student.model.Major;
import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.repository.StudentRepository;
import com.enigmacamp.student.repository.StudentRepositoryImpl;
import com.enigmacamp.student.service.StudentService;
import com.enigmacamp.student.service.StudentServiceImpl;
import com.enigmacamp.student.validation.EmptyAgeValidation;
import com.enigmacamp.student.validation.StudentAgeValidation;
import com.enigmacamp.student.validation.StudentNameLengthValidation;
import com.enigmacamp.student.validation.Validation;

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


        StudentRepository studentRepository = new StudentRepositoryImpl(5);
//        Validation ageValidation = new StudentAgeValidation(17);
        Validation ageValidation = new EmptyAgeValidation();
        Validation nameLengthValidation = new StudentNameLengthValidation(3, 20);
        StudentService studentService = new StudentServiceImpl(studentRepository, ageValidation, nameLengthValidation);

        // add data
        studentService.registerStudent(new Student("co", 29, new Major("Biologi")));
        studentService.registerStudent(new Student("Putra", 18, new Major("informatika")));
        studentService.registerStudent(new Student("Boba", 29, new Major("Fisika")));

        // delete data
        studentService.unregisterStudent();

        // view all data
        System.out.println("==== View all data ====");
        for (Student student : studentService.getAllStudent()) {
            System.out.println(student);
        }

        // view data by id
        System.out.println("\n==== Find by index ====");
        Student student = studentService.getStudentByIndex(0);
        System.out.println(student);
    }
}
