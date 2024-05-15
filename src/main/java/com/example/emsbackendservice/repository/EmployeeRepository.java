package com.example.emsbackendservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.emsbackendservice.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    @Query("select e from Employee e join department d where d.name= :departmentName")
    List<Employee> findAllEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    List<Employee> findAllByDepartmentName(String departmentName);

    List<Employee> findAllBySalaryLessThan(Double salary);

    List<Employee> findAllBySalaryGreaterThan(Double salary);

    @Query("select e from Employee e join fetch e.department")
    List<Employee> retrieveAll();
    
}
