
package com.example.emsbackendservice.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Employee> sortedList = employees.stream()
                                .sorted(Comparator.comparing(Employee::getName))
                                .collect(Collectors.toList());
        return EmployeeMapper.INSTACE.mapToList(sortedList);
    }

    @Override
    public List<EmployeeRecord> getEmployeesBySalary(Double salary, boolean toggle) {
        List<Employee> employees = employeeDao.getEmployeesBySalary(salary, toggle);
        List<Employee> sortedList = employees.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary))
                                .collect(Collectors.toList());
        return EmployeeMapper.INSTACE.mapToList(sortedList);
    }

    @Override
    public List<EmployeeRecord> getAllEmployeeAndDepartments() {
        List<Employee> employees = employeeDao.getAllEmployeeAndDepartments();
        return EmployeeMapper.INSTACE.mapToList(employees);
    }

    
}