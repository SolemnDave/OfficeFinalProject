package com.promineotech.office.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.office.entity.BranchLocations;
import com.promineotech.office.entity.Branches;

public interface OfficeBranchDao {
	
	List<Branches> fetchBranch(BranchLocations branch_name, String branch_id);

	Optional<Branches> createBranch(String branch_name, String branch_id);

	Optional<Branches> deleteBranch(String branch_name, String branch_id);

}
