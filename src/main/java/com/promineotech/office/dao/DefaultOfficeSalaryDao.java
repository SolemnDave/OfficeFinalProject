package com.promineotech.office.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.office.entity.Salary;
import com.promineotech.office.entity.YearlySalary;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultOfficeSalaryDao implements OfficeSalaryDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Salary> fetchSalary(YearlySalary yrSalary) {
		log.debug("DAO: yrSalary={}", yrSalary);

		String sql = "" + "SELECT * " 
						+ "FROM salary " 
						+ "WHERE yrSalary = :yrSalary ";

		Map<String, Object> params = new HashMap<>();
		params.put("yrSalary", yrSalary.toString());

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public Salary mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Salary.builder()
						.yrSalary(yrSalary)
						.build();
			}
		});

	}
}
