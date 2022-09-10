package com.promineotech.office.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.office.entity.Salary;
import com.promineotech.office.entity.YearlySalary;
import com.promineotech.office.service.OfficeSalaryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultOfficeSalaryController implements OfficeSalaryController {
	
	@Autowired
	private OfficeSalaryService officeSalaryService;

	@Override
	public List<Salary> createSalary(YearlySalary yrSalary) {
		log.debug("Salary={}", yrSalary);
		return officeSalaryService.createSalary(yrSalary);
	}

}
