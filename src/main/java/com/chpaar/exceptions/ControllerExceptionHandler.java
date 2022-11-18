package com.chpaar.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

        ErrorMessage message = new ErrorMessage(-20, new Date(), ex.getMessage(),
                "Error");
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getField() + "->" + x.getDefaultMessage())
                .collect(Collectors.toList());


        Map<String,String> ee = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap((x-> x.getCodes()[0]),
                        FieldError::getDefaultMessage ));

        ErrorMessage message = new ErrorMessage(-20, new Date(), errors.toString(),
                "InputNotValidException");

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
