package com.promineotech.office.entity;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salary implements Comparable<Salary>{
	
	private Long salary_pk;
	//private String salary_id;
	private YearlySalary yrSalary;
	
	@JsonIgnore
	public Long getSalPk() {
		return salary_pk;
	}
	
	@Override
	public int compareTo(Salary that) {
		return Comparator.comparing(Salary::getYrSalary)
				//.thenComparing(Salary::getYrSalary)
				.compare(this, that);
	}
	

}