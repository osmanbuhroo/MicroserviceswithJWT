package com.josh.departmentservice.service;

import com.josh.departmentservice.Exception.DepartmentNotFoundException;
import com.josh.departmentservice.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Object findDepartmentById(Long departmentId) throws DepartmentNotFoundException;
}
