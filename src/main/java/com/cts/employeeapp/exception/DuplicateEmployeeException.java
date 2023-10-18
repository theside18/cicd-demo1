package com.cts.employeeapp.exception;

public class DuplicateEmployeeException extends RuntimeException {

    public DuplicateEmployeeException(String message) {
        super(message);
    }


    private static final long serialVersionUID = 1L;
}
