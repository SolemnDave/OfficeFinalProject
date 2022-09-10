package com.promineotech.office.dao;

import java.util.Optional;

import com.promineotech.office.entity.Department;

public interface OfficeDepartmentDao {

	Optional<Department> createDept(String department_id, String dept_name);

}
