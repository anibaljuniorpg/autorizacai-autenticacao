package com.junior.autenticacao03.service;

import com.junior.autenticacao03.dtos.RestErrorMessage;
import com.junior.autenticacao03.exception.AuthenticationException;
import com.junior.autenticacao03.exception.RegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<RestErrorMessage> AuthenticationHandler(AuthenticationException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<RestErrorMessage> RegistrationHandler(RegistrationException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RestErrorMessage> IllegalArgumentHandler(IllegalArgumentException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }
}
