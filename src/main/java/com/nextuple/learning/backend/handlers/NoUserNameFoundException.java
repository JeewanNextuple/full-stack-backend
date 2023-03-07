package com.nextuple.learning.backend.handlers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN)
public class NoUserNameFoundException extends Exception{
    public NoUserNameFoundException(String errorMessage) {
        super(errorMessage);
    }
}
