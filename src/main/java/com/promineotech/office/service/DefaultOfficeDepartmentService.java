package com.promineotech.office.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.office.dao.OfficeDepartmentDao;
import com.promineotech.office.entity.Department;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultOfficeDepartmentService implements OfficeDepartmentService {
	
	@Autowired
	private OfficeDepartmentDao officeDeptDao;

	@Override
	public Optional<Department> createDept(String department_id, String dept_name) {
		log.info("A Dept. was created with department_id={} and dept_name={}", department_id, dept_name);
		return officeDeptDao.createDept(department_id, dept_name);
	}

}
