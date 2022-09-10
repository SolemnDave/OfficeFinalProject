package com.promineotech.office.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.office.entity.Salary;
import com.promineotech.office.entity.YearlySalary;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Salary")
@OpenAPIDefinition(info = @Info(title = "Office Salary Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface OfficeSalaryController {
	
	// create a job
		@Operation(
			      summary = "Creates a Salary.",
			      description = "Creates a Salary.",
			      responses = {
			          @ApiResponse(responseCode = "200", 
			              description = "A Salary is created", 
			              content = @Content(mediaType = "application/json", 
			              schema = @Schema(implementation = Salary.class))),
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
		  List<Salary> createSalary(
				  @RequestParam(required = false)
				  YearlySalary yrSalary);

}
