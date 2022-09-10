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
public class Job implements Comparable<Job>{

	private Long job_pk;
	private String job_title;
	private JobTitle job_id;
	private String first_name;
	private NewJobTitle new_job_title;
	
	@JsonIgnore
	public Long getJobPK() {
		return job_pk;
	}
	

	@Override
	public int compareTo(Job that) {
		// @formatter off
		return Comparator.comparing(Job::getJob_id)
				.thenComparing(Job::getFirst_name)
				.thenComparing(Job::getJob_title)
				.compare(this, that);

	}
	
}
