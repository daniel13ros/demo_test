package com.daniel.demo_test.advice;

import com.daniel.demo_test.exceptions.SchoolCostumeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by danielR on 08/12/2022
 */
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = {SchoolCostumeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handle(Exception e) {
        return new ErrorDetails(e.getMessage());
    }
}


