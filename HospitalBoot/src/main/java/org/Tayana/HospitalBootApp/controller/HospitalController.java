package org.Tayana.HospitalBootApp.controller;

import org.Tayana.HospitalBootApp.dto.Hospital;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

	
	@Autowired
	private HospitalService service;
	
	
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital)
	{
		return service.saveHospital(hospital);
	}
	
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital)
	{
		return service.saveHospital(hospital);
	}
	
	@DeleteMapping("/hospital/{hospital_id}")
	public ResponseEntity<ResponseStructure<String>>  deleteHospital(@PathVariable int hospital_id)
	{
		return service.deleteHospital(hospital_id);
	}
					
	
}
