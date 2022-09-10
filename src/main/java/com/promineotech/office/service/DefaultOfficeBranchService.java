package com.promineotech.office.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.office.dao.OfficeBranchDao;
import com.promineotech.office.entity.BranchLocations;
import com.promineotech.office.entity.Branches;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultOfficeBranchService implements OfficeBranchService {

	@Autowired
	private OfficeBranchDao officeBranchDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Branches> fetchBranch(BranchLocations branch_name, String branch_id) {
		log.info("The fetchBranch method was called with job={} and name={}", branch_name, branch_id);

		List<Branches> branch = officeBranchDao.fetchBranch(branch_name, branch_id);

		if (branch.isEmpty()) {
			String msg = String.format("No branches found with branch_id=%s and branch_name=%s", branch_name, branch_id);
			throw new NoSuchElementException(msg);
		}

		Collections.sort(branch);
		return branch;
	}

	@Override
	public Optional<Branches> createBranch(String new_branch, String branch_id) {
		log.info("A branch was created with new_branch={} and branch_id={}", new_branch, branch_id);
		return officeBranchDao.createBranch(new_branch, branch_id);
	}

	@Override
	public Optional<Branches> deleteBranch(String new_branch, String branch_id) {
		log.info("A branch was deleted with new_branch={} and branch_id={}", new_branch, branch_id);
		return officeBranchDao.deleteBranch(new_branch, branch_id);
	}

}
