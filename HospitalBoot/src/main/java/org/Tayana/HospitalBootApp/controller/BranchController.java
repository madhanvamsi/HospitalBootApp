package org.Tayana.HospitalBootApp.controller;

import org.Tayana.HospitalBootApp.dto.Branch;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {
	@Autowired
	 private BranchService service;
	
	@PostMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch,@PathVariable int id)
	{
	  return service.saveBranch(branch, id);
	}
	
	@PutMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch,@PathVariable int id)
	{
	  return service.updateBranch(branch, id);
	}
	
	
	@GetMapping("branch/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>> findBranchByhospitalId(@PathVariable int hospital_id)
	{
		return service.findBranchByHospitalId(hospital_id);
	}
	
	
}
