package com.example.emsbackendservice.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.emsbackendservice.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

import com.example.emsbackendservice.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EmployeeRepository employeeRepository;

    public EmployeeDaoImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentName(String departmentName) throws EntityNotFoundException{
        List<Employee> employees = employeeRepository.findAllEmployeesByDepartmentName(departmentName);
        if (!employees.isEmpty()) {
            return employees;
        }
        throw new EntityNotFoundException("No Employees found within this department " + departmentName);
    }

    @Override
    public List<Employee> getEmployeesBySalary(Double salary, boolean toggle) throws EntityNotFoundException {
        List<Employee> employees;
        if(toggle)
            employees = employeeRepository.findAllBySalaryLessThan(salary);
        else
            employees = employeeRepository.findAllBySalaryGreaterThan(salary);
        
        if (!employees.isEmpty()) {
            return employees;
        }
        throw new EntityNotFoundException("No Employees found with this salary condition " + salary);
    }

    @Override
    public List<Employee> getAllEmployeeAndDepartments() {
       return employeeRepository.retrieveAll();
    }
    
}
