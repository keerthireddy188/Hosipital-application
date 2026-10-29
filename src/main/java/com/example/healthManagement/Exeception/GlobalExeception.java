package com.example.healthManagement.Exeception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExeception {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorResponse>handlenotfound(ResourceNotFound ex){
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>handlevalidation(MethodArgumentNotValidException ex){
        String message=ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getBindingResult().getFieldError().getDefaultMessage(),LocalDateTime.now());
        return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
    }
}