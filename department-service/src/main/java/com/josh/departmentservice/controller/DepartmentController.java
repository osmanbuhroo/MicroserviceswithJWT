package com.josh.departmentservice.controller;

import com.josh.departmentservice.Exception.DepartmentNotFoundException;
import com.josh.departmentservice.entity.Department;
import com.josh.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity <Department> saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return ResponseEntity.status(CREATED).body(departmentService.saveDepartment(department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        log.info("Inside findDepartmentById method of DepartmentController");
        return ResponseEntity.status(OK).body(departmentService.findDepartmentById(departmentId));
    }
    @GetMapping("/")
    public  String Test (){
        return "welldone";
    }
}
