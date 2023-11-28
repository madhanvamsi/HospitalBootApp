package org.Tayana.HospitalBootApp.controller;

import org.Tayana.HospitalBootApp.dto.Doctor;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
	@Autowired
	private DoctorService service;
	
	@PostMapping("/doctor/{branch_id}/{person_id}")
	public ResponseEntity<ResponseStructure<Doctor>> save(@RequestBody Doctor doctor,@PathVariable int branch_id,@PathVariable int person_id)
	{
		return service.saveDoctor(doctor,branch_id,person_id);
	}
	
	@DeleteMapping("/doctor/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteDoctor(@PathVariable int id)
	{
		return service.deleteDoctor(id);
	}
	
}
