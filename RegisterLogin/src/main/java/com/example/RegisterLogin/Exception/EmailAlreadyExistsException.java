package com.example.RegisterLogin.Exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String massage){
        super(massage);

    }
}
