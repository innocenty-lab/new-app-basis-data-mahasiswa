package com.enigmacamp.student.validation;

import com.enigmacamp.student.model.Student;
import com.enigmacamp.student.util.Error;
import com.enigmacamp.student.util.ErrorResponse;
import com.enigmacamp.student.util.ResponseStatus;
import com.enigmacamp.student.util.SuccessResponse;

public class StudentNameLengthValidation implements Validation {
    private int minLen;
    private int maxLen;

    public StudentNameLengthValidation(int minLen, int maxLen) {
        this.minLen = minLen;
        this.maxLen = maxLen;
    }

    @Override
    public ResponseStatus test(Student s) {
        if (s.getFullName().length() >= minLen && s.getFullName().length() <= maxLen) return new SuccessResponse();
        return new ErrorResponse(Error.INVALID_LENGTH_NAME);
    }
}
