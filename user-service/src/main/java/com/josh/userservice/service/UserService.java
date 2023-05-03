package com.josh.userservice.service;

import com.josh.userservice.Exception.UserNotFoundException;
import com.josh.userservice.entity.Users;
import com.josh.userservice.valueObject.ResponseTemplateVO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    Users saveUser(Users users);

    ResponseTemplateVO getUserWithDepartment(Long userId) throws  Exception;

    ResponseTemplateVO saveUserWithDepartment(ResponseTemplateVO responseTemplateVO);
}
