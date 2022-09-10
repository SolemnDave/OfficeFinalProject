package com.promineotech.office.service;

import java.util.Optional;

import com.promineotech.office.entity.Department;



public interface OfficeDepartmentService {
	
	Optional<Department> createDept(String department_id, String dept_name);

	
	

}