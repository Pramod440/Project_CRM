package com.crm.exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String msg) {
        super(msg);
    }
    //whenever we create a custom exception, it should extend the RuntimeException(Exception) class
    //when we create a custom exception, it should contain a constructor with super keyword
}
