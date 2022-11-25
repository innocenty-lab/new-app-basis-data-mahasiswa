package com.enigmacamp.student.util;

public abstract class ResponseStatus {
    private boolean isValid;
    private Error error;

    public ResponseStatus(boolean isValid, Error error) {
        this.isValid = isValid;
        this.error = error;
    }

    public boolean isValid() {
        return isValid;
    }

    public Error getError() {
        return error;
    }
}
