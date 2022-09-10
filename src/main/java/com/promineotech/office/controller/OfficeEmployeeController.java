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

import com.promineotech.office.entity.EmployeeID;
import com.promineotech.office.entity.Employees;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Employees")
@OpenAPIDefinition(info = @Info(title = "Office Employee Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})


public interface OfficeEmployeeController {
  
  @Operation(
      summary = "Returns an Employee.",
      description = "Returns an Employee.",
      responses = {
          @ApiResponse(responseCode = "200", 
              description = "An Employee is returned", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Employees.class))),
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
  List<Employees> fetchEmployees(
		  @RequestParam(required = false)
		  EmployeeID first_name,
		  @Pattern(regexp = "[\\w\\s]+")
		  @RequestParam (required = false)
		  String last_name);
  
  @Operation(
	      summary = "Creates an Employee.",
	      description = "Creates an Employee.",
	      responses = {
	          @ApiResponse(responseCode = "200", 
	              description = "A created Employee is returned", 
	              content = @Content(mediaType = "application/json", 
	              schema = @Schema(implementation = Employees.class))),
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
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Employees> createEmployee(
		  @RequestParam(required = false)
		  String employee_id,
		  @RequestParam(required = false)
		  String last_name);
  
  @Operation(
	      summary = "Deletes an Employee.",
	      description = "Deletes an Employee.",
	      responses = {
	          @ApiResponse(responseCode = "200", 
	              description = "An Employee is deleted", 
	              content = @Content(mediaType = "application/json", 
	              schema = @Schema(implementation = Employees.class))),
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
  Optional<Employees> deleteEmployee(
		  @RequestParam(required = false)
		  String employee_id,
		  @RequestParam(required = false)
		  String last_name);
  
  @Operation(
	      summary = "Updates an Employee.",
	      description = "Updates an Employee.",
	      responses = {
	          @ApiResponse(responseCode = "200", 
	              description = "An Employee is updated", 
	              content = @Content(mediaType = "application/json", 
	              schema = @Schema(implementation = Employees.class))),
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
  Optional<Employees> updateEmployee(
		  @RequestParam(required = false)
		  String employee_id,
		  @RequestParam(required = false)
		  String last_name);
}