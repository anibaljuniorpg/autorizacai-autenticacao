package com.junior.autenticacao03.dtos;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {
    private HttpStatus status;
    private String message;
    public RestErrorMessage(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
