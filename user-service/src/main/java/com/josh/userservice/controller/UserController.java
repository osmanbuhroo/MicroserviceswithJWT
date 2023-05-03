package com.josh.userservice.controller;

import com.josh.userservice.Exception.UserNotFoundException;
import com.josh.userservice.entity.Users;
import com.josh.userservice.service.UserService;
import com.josh.userservice.valueObject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity <Users> saveUser(@RequestBody Users users)
    {
        log.info("Inside saveUser of UserController");
        return ResponseEntity.status(CREATED).body(userService.saveUser(users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable("id") Long userId) throws Exception {
        log.info("Inside getUserWithDepartment of UserController");
        return ResponseEntity.status(OK).body(userService.getUserWithDepartment(userId));
    }
    @PostMapping("/saveUserWithDepartment")
    public ResponseEntity<ResponseTemplateVO> saveUserWithDepartment(@RequestBody ResponseTemplateVO responseTemplateVO){
        return ResponseEntity.status(OK).body(userService.saveUserWithDepartment(responseTemplateVO));
    }


}
