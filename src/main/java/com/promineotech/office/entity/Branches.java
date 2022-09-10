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
public class Branches implements Comparable<Branches>{

	private long branch_pk;
	private String branch_id;
	private String new_branch;
	private BranchLocations branch_name;
	
	@JsonIgnore
	public Long getbranchPK() {
		return branch_pk;
	}
	
	@Override
	public int compareTo(Branches that) {
		// @formatter off
		return Comparator.comparing(Branches::getBranch_id)
				.thenComparing(Branches::getBranch_name)
				.thenComparing(Branches::getNew_branch)
				.compare(this, that);
	
	}
}