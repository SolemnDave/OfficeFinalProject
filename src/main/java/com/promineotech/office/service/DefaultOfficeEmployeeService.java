package com.promineotech.office.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.office.dao.OfficeEmployeeDao;
import com.promineotech.office.entity.EmployeeID;
import com.promineotech.office.entity.Employees;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultOfficeEmployeeService implements OfficeEmployeeService {
	
	@Autowired
	private OfficeEmployeeDao officeEmployeeDao;

	@Transactional(readOnly = true)
	@Override
	public List<Employees> fetchEmployees(EmployeeID first_name, String last_name) {
		log.info("The fetchJobs method was called with first_name={} and last_name={}",first_name, last_name);

		List<Employees> employees = officeEmployeeDao.fetchEmployees(first_name, last_name);

		if (employees.isEmpty()) {
			String msg = String.format("No jobs found with first_name={} and last_name=%s",first_name , last_name);
			throw new NoSuchElementException(msg);
		}

		Collections.sort(employees);
		return employees;
	}

	@Override
	public Optional<Employees> createEmployee(String employee_id, String last_name) {
		log.info("An Employee was created with employee_id={}, last_name={}", employee_id, last_name);
		return officeEmployeeDao.createEmployee(employee_id, last_name);
	}

	@Override
	public Optional<Employees> updateEmployee(String employee_id, String last_name) {
		log.info("An Employee was updated with employee_id={}", employee_id, last_name);
		return officeEmployeeDao.updateEmployee(employee_id, last_name);
	}

	@Override
	public Optional<Employees> deleteEmployee(String employee_id, String last_name) {
		log.info("An Employee was deleted with employee_id={}, last_name={}", employee_id, last_name);
		return officeEmployeeDao.deleteEmployee(employee_id, last_name);
	}

}
