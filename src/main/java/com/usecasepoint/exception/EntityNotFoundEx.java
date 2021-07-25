package com.usecasepoint.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundEx extends AppException {
    public EntityNotFoundEx() {
        super("Error " + HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
    }
}
