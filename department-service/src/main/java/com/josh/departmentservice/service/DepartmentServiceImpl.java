package com.josh.departmentservice.service;

import com.josh.departmentservice.Exception.DepartmentNotFoundException;
import com.josh.departmentservice.entity.Department;
import com.josh.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements  DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {

      return departmentRepository.save(department);

    }

    @Override
    public Object findDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        return departmentRepository.findById(departmentId).orElseThrow(()->
        new DepartmentNotFoundException("Invalid Department ID ........"));
    }
}
