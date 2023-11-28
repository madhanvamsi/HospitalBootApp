package org.Tayana.HospitalBootApp.service;

import java.util.Optional;

import org.Tayana.HospitalBootApp.dao.BranchDao;
import org.Tayana.HospitalBootApp.dao.HospitalDao;
import org.Tayana.HospitalBootApp.dto.Branch;
import org.Tayana.HospitalBootApp.dto.Hospital;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.exception.IdNotFoundException;
import org.Tayana.HospitalBootApp.repository.HopitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BranchService 
{
	
	@Autowired
	private BranchDao dao;
	@Autowired
	private HospitalDao hdao;
	@Autowired
	private HopitalRepository repository;
	
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch,int hospitalId)
	{
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Optional<Hospital>h=   repository.findById(hospitalId);
		if(h.isPresent())
		{
			Hospital h1=h.get(); //getting hospital data
			h1.getBranch().add(branch); //assigning branch to hospital
			branch.setHospital(h.get()); //setting hospital to branch
			dao.saveBranch(branch); //save the branch 
			hdao.updateHospital(h1); //update the hospital
			structure.setData(branch);
			structure.setMesssage("saved");
			structure.setHttpStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.ACCEPTED);
			
		}
		throw  new IdNotFoundException();
	}
	
	
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch,int hospitalId)
	{
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		Optional<Hospital> h= repository.findById(hospitalId);
		if(h.isPresent())
		{
			branch.setHospital(h.get()); //setting hospital to branch
			dao.updateBranch(branch); //save the branch 
			structure.setData(branch);
			structure.setMesssage("updated successfully");
			structure.setHttpStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
			
		}
		throw  new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Branch>> findBranchByHospitalId(int hospital_id)
	{
		ResponseStructure<Branch> Structure =new ResponseStructure<Branch>();
		Optional<Branch> branch=dao.findBranchByHospitalId(hospital_id);
		if(branch.isPresent())
		{
			Structure.setData(branch.get());
			Structure.setMesssage("branch find by the corresponding hospital id");
			Structure.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(Structure, HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException();
		}
		
	}
	
}
