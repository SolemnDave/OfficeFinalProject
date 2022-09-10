package com.promineotech.office.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.office.entity.EmployeeID;
import com.promineotech.office.entity.Employees;
import com.promineotech.office.service.OfficeEmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultOfficeEmployeeController implements OfficeEmployeeController {
	
	@Autowired
	private OfficeEmployeeService officeEmployeeService;

	@Override
	public List<Employees> fetchEmployees(EmployeeID first_name, String last_name) {
		log.debug("first_name={}, last_name={}",first_name, last_name);
		return officeEmployeeService.fetchEmployees(first_name, last_name);
	}

	@Override
	public Optional<Employees> createEmployee(String employee_id, String last_name) {
		log.debug("Employee={}, last_name={}", employee_id, last_name);
		return officeEmployeeService.createEmployee(employee_id, last_name);
	}

	@Override
	public Optional<Employees> deleteEmployee(String employee_id, String last_name) {
		log.debug("Employee={, last_name={}", employee_id, last_name);
		return officeEmployeeService.deleteEmployee(employee_id, last_name);
	}

	@Override
	public Optional<Employees> updateEmployee(String employee_id, String last_name) {
		log.debug("Employee={}", employee_id, last_name);
		return officeEmployeeService.updateEmployee(employee_id, last_name);
	}

}