package com.example.emsbackendservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.emsbackendservice.domain.Employee;
import com.example.emsbackendservice.records.EmployeeRecord;

@Mapper
public interface EmployeeMapper {
    
    EmployeeMapper INSTACE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "id", target = "employeeId")
    @Mapping(source = "name", target = "employeeName")
    @Mapping(source = "salary", target = "employeeSalary")
    @Mapping(source = "department.name", target = "departmentName")
    EmployeeRecord map(Employee employee);

    List<EmployeeRecord> mapToList(List<Employee> employees);

}
