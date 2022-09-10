package com.promineotech.office.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.office.entity.BranchLocations;
import com.promineotech.office.entity.Branches;
import com.promineotech.office.service.OfficeBranchService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultOfficeBranchController implements OfficeBranchController {
	
	@Autowired
	private OfficeBranchService officeBranchService;

	@Override
	public Optional<Branches> createBranch(String new_branch, String branch_id) {
		log.debug("Branch={}, ID={}", new_branch, branch_id);
		return officeBranchService.createBranch(new_branch, branch_id);
	}

	@Override
	public List<Branches> fetchBranch(BranchLocations branch_name, String branch_id) {
		log.debug("Branch={}, ID={}", branch_name, branch_id);
		return officeBranchService.fetchBranch(branch_name, branch_id);
	}

	@Override
	public Optional<Branches> deleteBranch(String new_branch, String branch_id) {
		log.debug("Branch={}, ID={}", new_branch, branch_id);
		return officeBranchService.deleteBranch(new_branch, branch_id);
	}

}
