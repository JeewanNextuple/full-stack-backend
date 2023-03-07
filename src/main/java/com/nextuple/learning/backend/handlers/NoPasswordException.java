package com.nextuple.learning.backend.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN)
public class NoPasswordException extends Exception{
        public NoPasswordException(String errorMessage) {
        super(errorMessage);

    }
}
