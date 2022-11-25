package com.enigmacamp.student.validation;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.ResponseStatus;

public interface Validation {
    ResponseStatus test(Student s);
}
