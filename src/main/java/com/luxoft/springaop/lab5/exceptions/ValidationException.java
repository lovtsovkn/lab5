package com.luxoft.springaop.lab5.exceptions;

public class ValidationException extends RuntimeException {

    private String message;

    public ValidationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
