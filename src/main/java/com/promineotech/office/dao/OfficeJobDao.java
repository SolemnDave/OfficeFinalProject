package com.promineotech.office.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.office.entity.Job;
import com.promineotech.office.entity.JobTitle;
import com.promineotech.office.entity.NewJobTitle;

public interface OfficeJobDao {
	
	List<Job> fetchJobs(JobTitle jobTitle, String first_name);
	
	Optional<Job> createJob(String job_title, String first_name);
	
	Optional<Job> updateJob(String job_title, NewJobTitle newJobTitle, JobTitle job_id);
	
	Optional<Job> deleteJob(String job_title, String first_name);

}
