package com.promineotech.office.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.office.entity.Job;
import com.promineotech.office.entity.JobTitle;
import com.promineotech.office.entity.NewJobTitle;
import com.promineotech.office.service.OfficeJobService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultOfficeJobController implements OfficeJobController {
	
	@Autowired
	private OfficeJobService officeJobService;

	@Override
	public List<Job> fetchJobs(JobTitle jobTitle, String first_name) {
		log.debug("Title={}, Name={}", jobTitle, first_name);
		return officeJobService.fetchJobs(jobTitle, first_name);
	}

	@Override
	public Optional<Job> createJob(String job_title, String first_name) {
		log.debug("Job={}", job_title);
		return officeJobService.createJob(job_title, first_name);
	}

	@Override
	public Optional<Job> deleteJob(String job_title, String first_name) {
		log.debug("Job={}", job_title, first_name);
		return officeJobService.deleteJob(job_title, first_name);
	}

	@Override
	public Optional<Job> updateJob(String job_title, NewJobTitle newJobTitle, JobTitle job_id) {
		log.debug("Job={}", job_title, newJobTitle, job_id);
		return officeJobService.updateJob(job_title, newJobTitle, job_id);
	}

}
