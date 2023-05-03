package com.josh.userservice.service;

import com.josh.userservice.Exception.UserNotFoundException;
import com.josh.userservice.entity.Users;
import com.josh.userservice.repository.UserRepository;
import com.josh.userservice.valueObject.Department;
import com.josh.userservice.valueObject.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HttpHeaders httpHeaders;

    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(Long userId) throws Exception {
        Users users = userRepository.findById(userId).orElseThrow(()->
                new UserNotFoundException("User Id is Invalid ........")
                );
        Department department =
                restTemplate.getForObject("http://Department-Service/departments/" + users.getDepartmentId()
                        , Department.class);
        ResponseTemplateVO responseTemplateVO = ResponseTemplateVO.builder()
                .users(users)
                .department(department)
                .build();
        return responseTemplateVO;
    }

    @Override
    public ResponseTemplateVO saveUserWithDepartment(ResponseTemplateVO responseTemplateVO) {
        userRepository.save(responseTemplateVO.getUsers());
        Department department=responseTemplateVO.getDepartment();
        HttpEntity<Department> departmentHttpEntity= new HttpEntity<>(department,httpHeaders);
        String url ="http://Department-Service/departments/save";
        ResponseEntity<Department> responseEntity= restTemplate.exchange(url,
                HttpMethod.POST,
                departmentHttpEntity,
                Department.class);
        return responseTemplateVO;
    }


}
