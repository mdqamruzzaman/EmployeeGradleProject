package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFound;
import com.employee.repository.EmpRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepository emprepo;

	// create employee
	@Override
	public Employee createEmployee(Employee emp) {
		return emprepo.save(emp);
	}

	// update employee
	@Override
	public Employee updateEmployee(Employee emp, int id) {
		Optional<Employee> getEmployee = emprepo.findById(id);
		if (getEmployee.isPresent()) {
			return emprepo.save(emp);
		} else {
			throw new EmployeeNotFound("Employee is not present in the databases");
		}
	}

	// delete employee
	@Override
	public void deleteEmployee(int id) {
		emprepo.deleteById(id);
	}

	// getEmployee by Id
	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> getEmployee = emprepo.findById(id);
		if(getEmployee.isPresent()) {
			return getEmployee.get();
		}else {
			throw new EmployeeNotFound("Employee is not present in the databases");
		}
	}

	// get all employee
	@Override
	public List<Employee> getAllEmployee() {
		return emprepo.findAll();
	}

}
