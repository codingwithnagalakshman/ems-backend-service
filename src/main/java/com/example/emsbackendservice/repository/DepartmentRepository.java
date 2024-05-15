package com.example.emsbackendservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emsbackendservice.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
