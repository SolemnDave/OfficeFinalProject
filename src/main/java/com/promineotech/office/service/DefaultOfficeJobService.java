package com.promineotech.office.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.office.dao.OfficeJobDao;
import com.promineotech.office.entity.Job;
import com.promineotech.office.entity.JobTitle;
import com.promineotech.office.entity.NewJobTitle;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultOfficeJobService implements OfficeJobService {
	
	@Autowired
	private OfficeJobDao officeJobDao;

	@Transactional(readOnly = true)
	@Override
	public List<Job> fetchJobs(JobTitle jobTitle, String first_name) {
		log.info("The fetchJobs method was called with job={} and name={}", jobTitle, first_name);

		List<Job> jobs = officeJobDao.fetchJobs(jobTitle, first_name);

		if (jobs.isEmpty()) {
			String msg = String.format("No jobs found with job=%s and name=%s", jobTitle, first_name);
			throw new NoSuchElementException(msg);
		}

		Collections.sort(jobs);
		return jobs;
	}

	@Override
	public Optional<Job> createJob(String job_title, String first_name) {
		log.info("A job was created with job={} and first_name={}", job_title, first_name);
		return officeJobDao.createJob(job_title, first_name);
	}

	@Override
	public Optional<Job> updateJob(String job_title, NewJobTitle newJobTitle, JobTitle job_id) {
		log.info("A job was updated with job={}", job_title, newJobTitle, job_id);
		return officeJobDao.updateJob(job_title, newJobTitle, job_id);
	}

	@Override
	public Optional<Job> deleteJob(String job_title, String first_name) {
		log.info("A job was deleted with job={}", job_title, first_name);
		return officeJobDao.deleteJob(job_title, first_name);
	}

}
