package com.josh.departmentservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception_Handler {
   @ExceptionHandler({DepartmentNotFoundException.class})
    public ResponseEntity<DepartmentNotFound>handleEmployeeNotFoundException(DepartmentNotFoundException departmentNotFound){
        DepartmentNotFound NotFound= DepartmentNotFound.builder()
                .message(departmentNotFound.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<DepartmentNotFound>(NotFound,HttpStatus.NOT_FOUND);
    }
}
