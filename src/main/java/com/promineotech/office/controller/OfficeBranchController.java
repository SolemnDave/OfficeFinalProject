package com.promineotech.office.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.office.entity.BranchLocations;
import com.promineotech.office.entity.Branches;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Branches")
@OpenAPIDefinition(info = @Info(title = "Office Branch Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface OfficeBranchController {
	
	
	// create a job
	@Operation(
		      summary = "Creates a Branch.",
		      description = "Creates a Branch.",
		      responses = {
		          @ApiResponse(responseCode = "200", 
		              description = "A Branch is created", 
		              content = @Content(mediaType = "application/json", 
		              schema = @Schema(implementation = Branches.class))),
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
	  Optional<Branches> createBranch(
			  @RequestParam(required = false)
			  String new_branch,
			  @RequestParam(required = false)
			  String branch_id);

	
	// return a job
	@Operation(
		      summary = "Returns a Branch.",
		      description = "Returns a Branch.",
		      responses = {
		          @ApiResponse(responseCode = "200", 
		              description = "A Branch is returned", 
		              content = @Content(mediaType = "application/json", 
		              schema = @Schema(implementation = Branches.class))),
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
	  List<Branches> fetchBranch(
		      @RequestParam (required = false)
		      	BranchLocations branch_name, 
		      @Pattern(regexp = "[\\w\\s]+")
		      @RequestParam (required = false)
		      	String branch_id);

	
	// delete a job
	@Operation(
		      summary = "Deletes a Branch.",
		      description = "Deletes a Branch.",
		      responses = {
		          @ApiResponse(responseCode = "200", 
		              description = "A Branch is deleted", 
		              content = @Content(mediaType = "application/json", 
		              schema = @Schema(implementation = Branches.class))),
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
	  Optional<Branches> deleteBranch(
			  @RequestParam(required = false)
			  String new_branch,
			  @RequestParam(required = false)
			  String branch_id);

}