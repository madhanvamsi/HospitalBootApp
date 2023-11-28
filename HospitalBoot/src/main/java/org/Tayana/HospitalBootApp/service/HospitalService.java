package org.Tayana.HospitalBootApp.service;

import java.util.Optional;

import org.Tayana.HospitalBootApp.dao.HospitalDao;
import org.Tayana.HospitalBootApp.dto.Hospital;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.exception.IdNotFoundException;
import org.Tayana.HospitalBootApp.repository.HopitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao dao;
	@Autowired
	private HopitalRepository repository;
	
	//save 
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital)
	{
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		structure.setData(dao.SaveHospital(hospital));
		structure.setMesssage("hospital saved successfully");
		structure.setHttpStatus(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.ACCEPTED);
	
	}
	
	//update 
	public ResponseEntity<ResponseStructure<Hospital>>  updateHospital(Hospital hospital)
	{
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		structure.setData(dao.updateHospital(hospital));
		structure.setMesssage("hospital updated successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
	
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteHospital(int hospital_id)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		Optional<Hospital> hospital=repository.findById(hospital_id); //finding details of hospital through hospital_id
		if(hospital.isPresent())
		{
			dao.deleteHospital(hospital_id);
			structure.setData("hospital details deleted successfuly");
			structure.setMesssage("deleted ");
			structure.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
	
}
