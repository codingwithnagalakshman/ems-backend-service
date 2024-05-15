package com.example.emsbackendservice.utils;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.emsbackendservice.domain.Department;
import com.example.emsbackendservice.domain.Employee;
import com.example.emsbackendservice.repository.DepartmentRepository;
import com.example.emsbackendservice.repository.EmployeeRepository;
import com.github.javafaker.Faker;

@Component
public class DataDumpHelper implements CommandLineRunner {
    
	private EmployeeRepository employeeRepository;

	private DepartmentRepository departmentRepository;

	public DataDumpHelper(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}


    @Override
	public void run(String... args) throws Exception {
       
		Faker faker = new Faker();
		
		List<String> departmentNames = List.of("Human Resources",
										"Finance","Marketing","Sales",
										"Operations","Information Technology","Customer Service",
										"Research and Development",	"Legal",
										"Administration","Procurement/Purchasing",
										"Product Development","Quality Assurance",
										"Supply Chain Management","Public Relations",
										"Training and Development","Corporate Strategy",
				"Engineering", "Logistics", "Compliance");
										
		departmentNames.stream().forEach(departmentName -> {
			Department department = new Department();
			department.setName(departmentName);
			departmentRepository.save(department);

			IntStream.rangeClosed(1, 20).forEach(number -> {
			Employee employee = new Employee(
				faker.name().name(), 
				faker.number().randomDouble(0, 5000, 45000), 
					department);
			employeeRepository.save(employee);
			});
		
		});
        
    }
    
}
