package com.example.emsbackendservice.dao;

import java.util.List;

import com.example.emsbackendservice.domain.Employee;

public interface EmployeeDao {

    List<Employee> getEmployeesByDepartmentName(String departmentName);

    List<Employee> getEmployeesBySalary(Double salary, boolean toggle);

    List<Employee> getAllEmployeeAndDepartments();
    
}
