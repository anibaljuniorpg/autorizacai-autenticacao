package com.junior.autenticacao03.exception;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException(){super("Usuario não encontrado");}
    AuthenticationException(String message){super(message);}
}
