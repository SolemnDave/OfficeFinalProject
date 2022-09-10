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
public class Employees implements Comparable<Employees>{
	
	private Long employee_pk;
	private String employee_id;
	private String last_name;
	private EmployeeID first_name;
	
	@JsonIgnore
	public Long getEmpPk() {
		return employee_pk;
	}
	
	
	public int compareTo(Employees that) {
		// @formatter off
		return Comparator.comparing(Employees::getEmployee_id)
				.thenComparing(Employees::getLast_name)
				.thenComparing(Employees::getFirst_name)
				.compare(this, that);
		// @formatter on
	}

}
