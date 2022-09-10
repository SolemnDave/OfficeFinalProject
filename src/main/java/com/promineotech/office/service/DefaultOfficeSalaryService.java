package com.promineotech.office.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.office.dao.OfficeSalaryDao;
import com.promineotech.office.entity.Salary;
import com.promineotech.office.entity.YearlySalary;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultOfficeSalaryService implements OfficeSalaryService {
	
	@Autowired
	private OfficeSalaryDao officeSalaryDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Salary> createSalary(YearlySalary yrSalary) {
		log.info("The createSalary method was called with yrSalary={}", yrSalary);

		List<Salary> salary = officeSalaryDao.fetchSalary(yrSalary);

		if (salary.isEmpty()) {
			String msg = String.format("No Salary found with yrSalary=%s", yrSalary);
			throw new NoSuchElementException(msg);
		}

		Collections.sort(salary);
		return salary;
	
	}

}
