package com.usecasepoint.exception;

import org.springframework.http.HttpStatus;

public class BadRequestEx extends AppException{
    public BadRequestEx() {
        super(HttpStatus.BAD_REQUEST + " pocket didn't match with the product!", HttpStatus.BAD_REQUEST);
    }
}
