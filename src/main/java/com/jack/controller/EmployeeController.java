package com.jack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jack.entity.Employee;
import com.jack.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.saveEmployee(employee);
	}

	@PostMapping("/createAll")
	public List<Employee> createAllEmployee(@RequestBody List<Employee> emloyee){
		return empService.saveAllEmployee(emloyee);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee(){
		return empService.findAllEmployee();
	}
	
	@GetMapping("/getByName/{name}")
	public Employee getEmployee(@PathVariable("name") String name) {
		return empService.getByName(name);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return empService.removeEmployee(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {	
		return empService.updateEmployee(id, employee);
	}
}