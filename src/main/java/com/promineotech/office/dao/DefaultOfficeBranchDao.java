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

import com.promineotech.office.entity.BranchLocations;
import com.promineotech.office.entity.Branches;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultOfficeBranchDao implements OfficeBranchDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Branches> fetchBranch(BranchLocations branch_name, String branch_id) {
		log.debug("DAO: branch_name={}, branch_id={}", branch_name, branch_id);

		String sql = "" + "SELECT * " 
						+ "FROM branch " 
						+ "WHERE branch_name = :branch_name AND branch_id = :branch_id ";

		Map<String, Object> params = new HashMap<>();
		params.put("branch_name", branch_name.toString());
		params.put("branch_id", branch_id);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public Branches mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Branches.builder()
						.branch_name(BranchLocations.valueOf(rs.getString("branch_name")))
						.branch_id(rs.getString("branch_id"))
						.build();
			}
		});
	}

	@Override
	public Optional<Branches> createBranch(String new_branch, String branch_id) {
		log.debug("DAO: new_branch={}, branch_id={}", new_branch, branch_id);

		//@formatter:off
	    String sql = ""
	        + "INSERT INTO branch ("
	        + "new_branch, branch_id"
	        + ") VALUES ("
	        +  ":new_branch, :branch_id)";
	    //@formatter:on
	    
		Map<String, Object> params = new HashMap<>();
		params.put("new_branch", new_branch);
		params.put("branch_id", branch_id);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Branches.builder()
						.new_branch(new_branch)
						.branch_id(branch_id)
						.build());
	}

	@Override
	public Optional<Branches> deleteBranch(String new_branch, String branch_id) {
		log.debug("DAO: new_branch={}, branch_id={}", new_branch, branch_id);

		//@formatter:off
	    String sql = ""
	        + "DELETE FROM branch WHERE "
	        + "new_branch = :new_branch AND "
	        + "branch_id = :branch_id";
	    //@formatter:on
	    
		Map<String, Object> params = new HashMap<>();
		params.put("new_branch", new_branch);
		params.put("branch_id", branch_id);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Branches.builder()
						.new_branch(new_branch)
						.branch_id(branch_id)
						.build());

	}
}
