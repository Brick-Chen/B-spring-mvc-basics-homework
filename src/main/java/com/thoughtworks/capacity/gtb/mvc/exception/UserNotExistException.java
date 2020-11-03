package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(String message) {
        super(message);
    }
}
