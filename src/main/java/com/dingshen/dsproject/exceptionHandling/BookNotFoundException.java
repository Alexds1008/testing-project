package com.dingshen.dsproject.exceptionHandling;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
