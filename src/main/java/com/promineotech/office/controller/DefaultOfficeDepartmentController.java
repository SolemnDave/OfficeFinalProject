package com.promineotech.office.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.office.entity.Department;
import com.promineotech.office.service.OfficeDepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultOfficeDepartmentController implements OfficeDepartmentController {
	
	@Autowired
	private OfficeDepartmentService officeDeptService;

	@Override
	public Optional<Department> createDept(String department_id, String dept_name) {
		log.debug("department_id={}, dept_name={}", department_id, dept_name);
		return officeDeptService.createDept(department_id, dept_name);
	}

}
