package org.Tayana.HospitalBootApp.dao;

import java.util.Optional;

import org.Tayana.HospitalBootApp.dto.Branch;
import org.Tayana.HospitalBootApp.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDao
{
	@Autowired
	private BranchRepository repository;
	
	public Branch saveBranch(Branch branch)
	{
		return repository.save(branch);
	}
	
	public Branch updateBranch(Branch branch)
	{
		return repository.save(branch);
	}
	
	public Optional<Branch> findBranchByHospitalId(int hospital_id)
	{
		return repository.findBranchByHospitalId(hospital_id);
	}
	
	
	
	
}
