package com.vinsguru.advice;

import com.vinsguru.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    // ProblemDetail is part of Spring Framework 6 and provides a standardized way to represent errors in HTTP APIs.
    // It is based on the RFC 7807 specification, which defines a common format for error responses in RESTful APIs.
    public ProblemDetail handleException(CustomerNotFoundException ex){
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Customer Not Found");
        return problem;
    }

}
