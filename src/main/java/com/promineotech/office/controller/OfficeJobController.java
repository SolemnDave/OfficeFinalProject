package com.promineotech.office.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.office.entity.Job;
import com.promineotech.office.entity.JobTitle;
import com.promineotech.office.entity.NewJobTitle;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Job")
@OpenAPIDefinition(info = @Info(title = "Office Job Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface OfficeJobController {
	
	
	// create a job
	@Operation(
		      summary = "Creates a Job.",
		      description = "Creates a Job.",
		      responses = {
		          @ApiResponse(responseCode = "200", 
		              description = "A Job is created", 
		              content = @Content(mediaType = "application/json", 
		              schema = @Schema(implementation = Job.class))),
		          @ApiResponse(responseCode = "400", 
		            description = "The request parameters are invalid", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "404", 
		            description = "No Jobs were found with the input criteria", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "500", 
		            description = "An unplanned error occurred", 
		            content = @Content(mediaType = "application/json"))
		      },
		      
		      parameters = {
		    		  @Parameter(
		    				  name = "job_title",
		    				  allowEmptyValue = false,
		    				  required = false,
		    				  description = "The Job name is ..."),
		    		  @Parameter(
		    				  name = "first_name",
		    				  allowEmptyValue = false,
		    				  required = false,
		    				  description = "The employees name is ...")
		      }
			)
	  
	  @PostMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  Optional<Job> createJob(
			  @RequestParam(required = false)
			  String job_title,
			  @RequestParam(required = false)
			  String first_name);

	
	// return a job
	@Operation(
		      summary = "Returns a Job.",
		      description = "Returns a Job.",
		      responses = {
		          @ApiResponse(responseCode = "200", 
		              description = "A Job is returned", 
		              content = @Content(mediaType = "application/json", 
		              schema = @Schema(implementation = Job.class))),
		          @ApiResponse(responseCode = "400", 
		            description = "The request parameters are invalid", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "404", 
		            description = "No Employees were found with the input criteria", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "500", 
		            description = "An unplanned error occurred", 
		            content = @Content(mediaType = "application/json"))
		      }
			)
	  
	  @GetMapping
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Job> fetchJobs(
		      @RequestParam (required = false)
		      	JobTitle jobTitle, 
		      @Pattern(regexp = "[\\w\\s]+")
		      @RequestParam (required = false)
		      	String first_name);

	
	// delete a job
	@Operation(
		      summary = "Deletes a Job.",
		      description = "Deletes a Job.",
		      responses = {
		          @ApiResponse(responseCode = "200", 
		              description = "A Job is deleted", 
		              content = @Content(mediaType = "application/json", 
		              schema = @Schema(implementation = Job.class))),
		          @ApiResponse(responseCode = "400", 
		            description = "The request parameters are invalid", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "404", 
		            description = "No Employees were found with the input criteria", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "500", 
		            description = "An unplanned error occurred", 
		            content = @Content(mediaType = "application/json"))
		      }
			)
	  
	  @DeleteMapping
	  @ResponseStatus(code = HttpStatus.OK)
	  Optional<Job> deleteJob(
			  @RequestParam(required = false)
			  String job_title,
			  @RequestParam(required = false)
			  String first_name);

	
	// update a job
	@Operation(
		      summary = "Updates a Job.",
		      description = "Updates a Job.",
		      responses = {
		          @ApiResponse(responseCode = "200", 
		              description = "A Job is updated", 
		              content = @Content(mediaType = "application/json", 
		              schema = @Schema(implementation = Job.class))),
		          @ApiResponse(responseCode = "400", 
		            description = "The request parameters are invalid", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "404", 
		            description = "No Employees were found with the input criteria", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "500", 
		            description = "An unplanned error occurred", 
		            content = @Content(mediaType = "application/json"))
		      }
			)
	  
	  @PutMapping
	  @ResponseStatus(code = HttpStatus.OK)
	  Optional<Job> updateJob(
			  @RequestParam(required = false)
			  String job_title,
			  @RequestParam(required = false)
			  NewJobTitle newJobTitle,
			  @RequestParam(required = false)
			  JobTitle job_id);

}
