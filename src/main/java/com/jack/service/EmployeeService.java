package com.jack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.entity.Employee;
import com.jack.repository.EmployeeRepository;

@Service

public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	public Employee saveEmployee(Employee employee) {
		return empRepository.save(employee);
	}

	public List<Employee> saveAllEmployee(List<Employee> employee) {
		return empRepository.saveAll(employee);
	}

	public List<Employee> findAllEmployee() {
		return empRepository.findAll();
	}

	public Employee getByName(String name) {
		return empRepository.findByName(name).orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	public String removeEmployee(Long id) {
		empRepository.deleteById(id);
		return "Employee Succesfully removed";
	}

	public Employee updateEmployee(Long id, Employee employee) {
		Employee existing = empRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

		existing.setName(employee.getName());
		existing.setEmail(employee.getEmail());

		return empRepository.save(existing);
	}
}
