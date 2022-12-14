package com.enigmacamp.student.validation;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.Error;
import com.enigmacamp.student.util.ErrorResponse;
import com.enigmacamp.student.util.ResponseStatus;
import com.enigmacamp.student.util.SuccessResponse;

public class StudentAgeValidation implements Validation {
    private int minAge;

    public StudentAgeValidation(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public ResponseStatus test(Student s) {
        if (s.getUmur() >= minAge) return new SuccessResponse();
        return new ErrorResponse(Error.INVALID_AGE);
    }
}
