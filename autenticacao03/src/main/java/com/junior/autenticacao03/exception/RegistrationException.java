package com.junior.autenticacao03.exception;

public class RegistrationException extends RuntimeException{
    public RegistrationException(){super("Usuario ja existe");}
    public RegistrationException(String message){super(message);}
}
