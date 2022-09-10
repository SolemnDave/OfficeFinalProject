package com.promineotech.office.dao;

import java.util.List;

import com.promineotech.office.entity.Salary;
import com.promineotech.office.entity.YearlySalary;

public interface OfficeSalaryDao {

	List<Salary> fetchSalary(YearlySalary yrSalary);
	
}
