package com.promineotech.office.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.office.entity.Department;
import com.promineotech.office.entity.Job;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Department")
@OpenAPIDefinition(info = @Info(title = "Office Department Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface OfficeDepartmentController {

	// create a job
	@Operation(
		      summary = "Creates a Department.",
		      description = "Creates a Department.",
		      responses = {
		          @ApiResponse(responseCode = "200", 
		              description = "A Department is created", 
		              content = @Content(mediaType = "application/json", 
		              schema = @Schema(implementation = Job.class))),
		          @ApiResponse(responseCode = "400", 
		            description = "The request parameters are invalid", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "404", 
		            description = "No Departments were found with the input criteria", 
		            content = @Content(mediaType = "application/json")),
		          @ApiResponse(responseCode = "500", 
		            description = "An unplanned error occurred", 
		            content = @Content(mediaType = "application/json"))
		      },
		      
		      parameters = {
		    		  @Parameter(
		    				  name = "department_id",
		    				  allowEmptyValue = false,
		    				  required = false,
		    				  description = "The Department ID is ..."),
		    		  @Parameter(
		    				  name = "dept_name",
		    				  allowEmptyValue = false,
		    				  required = false,
		    				  description = "The Department name is ...")
		      }
			)
	  
	  @PostMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  Optional<Department> createDept(
			  @RequestParam(required = false)
			  String department_id,
			  @RequestParam(required = false)
			  String dept_name);
	
}
