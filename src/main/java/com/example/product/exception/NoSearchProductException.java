package com.example.product.exception;

public class NoSearchProductException extends RuntimeException {
    //
    private static final long serialVersionUID = 6387382920586717250L;

    public NoSearchProductException(String message) {

        super(message);
    }
}