package com.promineotech.office.service;

import java.util.List;

import com.promineotech.office.entity.Salary;
import com.promineotech.office.entity.YearlySalary;

public interface OfficeSalaryService {
	
	List<Salary> createSalary(YearlySalary yrSalary);

}
