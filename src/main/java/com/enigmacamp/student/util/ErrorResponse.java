package com.enigmacamp.student.util;

public class ErrorResponse extends ResponseStatus {

//    public ErrorResponse(boolean isValid, Error error) {
//        super(false, error);
//    }

    public ErrorResponse(Error error) {
        super(false, error);
    }
}
