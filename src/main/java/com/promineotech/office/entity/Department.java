package com.promineotech.office.entity;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Comparable<Department> {

	private String department_id;
	private String dept_name;

	public int compareTo(Department that) {
		// @formatter off
		return Comparator.comparing(Department::getDepartment_id)
						 .thenComparing(Department::getDept_name)
						 .compare(this,that);
		// @formatter on

	}
}