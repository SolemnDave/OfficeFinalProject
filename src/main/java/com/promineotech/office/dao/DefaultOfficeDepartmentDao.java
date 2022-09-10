package com.promineotech.office.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.office.entity.Department;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultOfficeDepartmentDao implements OfficeDepartmentDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Optional<Department> createDept(String department_id, String dept_name) {
		log.debug("DAO: department_id={}, dept_name={}", department_id, dept_name);

		//@formatter:off
	    String sql = ""
	        + "INSERT INTO department ("
	        + "department_id, dept_name"
	        + ") VALUES ("
	        +  ":department_id, :dept_name)";
	    //@formatter:on
	    
		Map<String, Object> params = new HashMap<>();
		params.put("department_id", department_id);
		params.put("dept_name", dept_name);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Department.builder()
						.department_id(department_id)
						.dept_name(dept_name)
						.build());
	}

}
