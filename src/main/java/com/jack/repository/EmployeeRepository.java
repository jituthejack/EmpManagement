package com.jack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByName(String name);
	
}
