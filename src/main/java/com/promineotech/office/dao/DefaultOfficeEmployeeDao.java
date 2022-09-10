package com.promineotech.office.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.office.entity.EmployeeID;
import com.promineotech.office.entity.Employees;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultOfficeEmployeeDao implements OfficeEmployeeDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	
	@Override
	public List<Employees> fetchEmployees(EmployeeID first_name, String last_name) {
		log.debug("DAO: first_name={}, last_name={}", first_name, last_name);

		String sql = "" + "SELECT * " 
						+ "FROM employees " 
						+ "WHERE first_name = :first_name AND last_name = :last_name ";

		Map<String, Object> params = new HashMap<>();
		params.put("first_name", first_name.toString());
		params.put("last_name", last_name);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Employees.builder()
						.first_name(EmployeeID.valueOf(rs.getString("first_name")))
						.last_name(rs.getString("last_name"))
						.build();
			}
		});


	}

	@Override
	public Optional<Employees> createEmployee(String employee_id, String last_name) {
		log.debug("DAO: employee_id={}, last_name={}", employee_id, last_name);

		//@formatter:off
	    String sql = ""
	        + "INSERT INTO employees ("
	        + "employee_id, last_name"
	        + ") VALUES ("
	        +  ":employee_id, :last_name)";
	    //@formatter:on
	    
		Map<String, Object> params = new HashMap<>();
		params.put("employee_id", employee_id);
		params.put("last_name", last_name);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Employees.builder()
						.employee_id(employee_id)
						.last_name(last_name)
						.build());

	}

	@Override
	public Optional<Employees> updateEmployee(String employee_id, String last_name) {
		
		log.info("DAO: employee_id={}, last_name={}", employee_id, last_name);
		  
		  //@formatter:off
		  String sql = ""
		      + "UPDATE employees SET employee_id = :last_name "
		      + "WHERE employee_id = :employee_id AND last_name = :last_name";

		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("employee_id", employee_id);
		  params.put("last_name", last_name);
		  
		  jdbcTemplate.update(sql, params);
		  return Optional.ofNullable(Employees.builder()
				  		 .last_name(last_name)
				  		 .employee_id(employee_id)
				  		 .build());
		      }
		

	@Override
	public Optional<Employees> deleteEmployee(String employee_id, String last_name) {
		
		log.debug("DAO: employee_id={}, last_name={}", employee_id, last_name);

		//@formatter:off
	    String sql = ""
	        + "DELETE FROM employees WHERE "
	        + "employee_id = :employee_id AND "
	        + "last_name = :last_name";
	    //@formatter:on
	    
		Map<String, Object> params = new HashMap<>();
		params.put("employee_id", employee_id);
		params.put("last_name", last_name);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Employees.builder()
						.employee_id(employee_id)
						.last_name(last_name)
						.build());
		
	}

}
