package com.example.emsbackendservice.service;

import java.util.List;

import com.example.emsbackendservice.records.EmployeeRecord;

public interface EmployeeService {

	List<EmployeeRecord> getEmployeesByDepartmentName(String departmentName);

    List<EmployeeRecord> getEmployeesBySalary(Double salary, boolean toggle);

    List<EmployeeRecord> getAllEmployeeAndDepartments();
    
}
