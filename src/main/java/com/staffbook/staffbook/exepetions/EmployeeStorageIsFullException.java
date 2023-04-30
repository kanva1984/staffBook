package com.staffbook.staffbook.exepetions;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
