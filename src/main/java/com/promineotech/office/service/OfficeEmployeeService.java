package com.promineotech.office.service;

import java.util.List;
import java.util.Optional;

import com.promineotech.office.entity.EmployeeID;
import com.promineotech.office.entity.Employees;


public interface OfficeEmployeeService {
	
	List<Employees> fetchEmployees(EmployeeID first_name, String last_name);
	
	Optional<Employees> createEmployee(String employee_id, String last_name);
	
	Optional<Employees> updateEmployee(String employee_id, String last_name);
	
	Optional<Employees> deleteEmployee(String employee_id, String last_name);

}
