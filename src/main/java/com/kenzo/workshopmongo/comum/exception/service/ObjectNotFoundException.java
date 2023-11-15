package com.kenzo.workshopmongo.comum.exception.service;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
