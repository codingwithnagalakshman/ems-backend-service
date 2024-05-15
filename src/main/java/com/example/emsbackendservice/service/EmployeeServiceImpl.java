
package com.example.emsbackendservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.emsbackendservice.dao.EmployeeDao;
import com.example.emsbackendservice.domain.Employee;
import com.example.emsbackendservice.mapper.EmployeeMapper;
import com.example.emsbackendservice.records.EmployeeRecord;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<EmployeeRecord> getEmployeesByDepartmentName(String departmentName) {
        List<Employee> employees = employeeDao.getEmployeesByDepartmentName(departmentName);
        return EmployeeMapper.INSTACE.mapToList(employees);
    }

    @Override
    public List<EmployeeRecord> getEmployeesBySalary(Double salary, boolean toggle) {
        List<Employee> employees = employeeDao.getEmployeesBySalary(salary, toggle);
        return EmployeeMapper.INSTACE.mapToList(employees);
    }

    @Override
    public List<EmployeeRecord> getAllEmployeeAndDepartments() {
        List<Employee> employees = employeeDao.getAllEmployeeAndDepartments();
        return EmployeeMapper.INSTACE.mapToList(employees);
    }

    
}