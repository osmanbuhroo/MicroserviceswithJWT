package com.josh.userservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception_Handler {
    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<UserNotFound> handleEmployeeNotFoundException(UserNotFoundException userNotFoundException){
        UserNotFound NotFound= UserNotFound.builder()
                .message(userNotFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<UserNotFound>(NotFound,HttpStatus.NOT_FOUND);
    }
}