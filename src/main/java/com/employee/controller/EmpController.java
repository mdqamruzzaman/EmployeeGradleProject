package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeServiceImpl;

@RestController
public class EmpController {

	@Autowired
	private EmployeeServiceImpl empService;

	@PostMapping(value = "/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(empService.createEmployee(emp), HttpStatus.CREATED);
	}

	@GetMapping(value = "/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		return new ResponseEntity<Employee>(empService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		return new ResponseEntity<Employee>(empService.updateEmployee(emp, id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteEmployee")
	public ResponseEntity<?> deleteEmployee(@RequestParam int id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Details is Now Deleted", HttpStatus.OK);
	}

	@GetMapping(value = "/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity<List<Employee>>(empService.getAllEmployee(), HttpStatus.OK);
	}
}
