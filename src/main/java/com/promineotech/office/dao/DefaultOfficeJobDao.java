package com.promineotech.office.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.office.entity.Job;
import com.promineotech.office.entity.JobTitle;
import com.promineotech.office.entity.NewJobTitle;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultOfficeJobDao implements OfficeJobDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	@Override
	public List<Job> fetchJobs(JobTitle jobTitle, String first_name) {
		log.debug("DAO: jobTitle={}, first_name={}", jobTitle, first_name);

		String sql = "" + "SELECT * " 
						+ "FROM job " 
						+ "WHERE job_id = :job_id AND first_name = :first_name ";

		Map<String, Object> params = new HashMap<>();
		params.put("job_id", jobTitle.toString());
		params.put("first_name", first_name);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Job.builder()
						.job_id(JobTitle.valueOf(rs.getString("job_id")))
						.first_name(rs.getString("first_name"))
						.build();
			}
		});

	}
	
	@Override
	public Optional<Job> createJob(String job_title, String first_name) {
		log.debug("DAO: job_title={}", job_title, first_name);

		//@formatter:off
	    String sql = ""
	        + "INSERT INTO job ("
	        + "job_title, first_name"
	        + ") VALUES ("
	        +  ":job_title, :first_name)";
	    //@formatter:on
	    
		Map<String, Object> params = new HashMap<>();
		params.put("job_title", job_title);
		params.put("first_name", first_name);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Job.builder()
						.job_title(job_title)
						.first_name(first_name)
						.build());
	}


	@Override
	public Optional<Job> updateJob(String job_title, NewJobTitle newJobTitle, JobTitle job_id) {
		log.info("DAO: job_title={}, new_job_title={}", job_title, newJobTitle);
		  
		  //@formatter:off
		  String sql = ""
		      + "UPDATE job SET job_title = :new_job_title "
		      + "WHERE job_id = :job_id AND job_title = :job_title";
 
		  //@formatter:on
		  
		  Map<String, Object> params = new HashMap<>();
		  params.put("job_title", job_title);
		  params.put("new_job_title", newJobTitle.toString());
		  params.put("job_id", job_id.toString());
		  
		  jdbcTemplate.update(sql, params);
		  return Optional.ofNullable(Job.builder()
				  		 .job_title(job_title)
				  		 .new_job_title(newJobTitle)
				  		 .job_id(job_id)
				  		 .build());
		      }


	@Override
	public Optional<Job> deleteJob(String job_title, String first_name) {
		
		log.debug("DAO: job_title={}, first_name={}", job_title, first_name);

		//@formatter:off
	    String sql = ""
	        + "DELETE FROM job WHERE "
	        + "job_title = :job_title AND "
	        + "first_name = :first_name";
	    //@formatter:on
	    
		Map<String, Object> params = new HashMap<>();
		params.put("job_title", job_title);
		params.put("first_name", first_name);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Job.builder()
						.job_title(job_title)
						.first_name(first_name)
						.build());
		
	}
}
