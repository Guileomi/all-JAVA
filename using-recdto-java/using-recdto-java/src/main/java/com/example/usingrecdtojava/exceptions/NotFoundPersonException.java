package com.example.usingrecdtojava.exceptions;

public class NotFoundPersonException extends RuntimeException{

    public NotFoundPersonException(String messege){
        super(messege);
    }

    public NotFoundPersonException(String messege, Throwable cause){
        super(messege, cause);
    }
}
