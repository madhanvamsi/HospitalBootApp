package org.Tayana.HospitalBootApp.service;

import java.util.Optional;

import org.Tayana.HospitalBootApp.dao.BranchDao;
import org.Tayana.HospitalBootApp.dao.DoctorDao;
import org.Tayana.HospitalBootApp.dao.PersonDao;
import org.Tayana.HospitalBootApp.dto.Branch;
import org.Tayana.HospitalBootApp.dto.Doctor;
import org.Tayana.HospitalBootApp.dto.Person;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.exception.IdNotFoundException;
import org.Tayana.HospitalBootApp.repository.BranchRepository;
import org.Tayana.HospitalBootApp.repository.DoctorRepository;
import org.Tayana.HospitalBootApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DoctorService 
{
	@Autowired
	private DoctorDao dao;
	@Autowired
	private BranchDao bdao;
	@Autowired
	private BranchRepository repository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PersonDao pdao;
	
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor,int branch_id, int person_id)
	{
		ResponseStructure<Doctor> structure=new ResponseStructure<>();
		Optional<Branch> b=repository.findById(branch_id); //fetching branch details using branch ID
		Optional<Person> person=personRepository.findById(person_id); //fetching person details using person ID
		if(b.isPresent() && person.isPresent())
		{	
			Branch branch=b.get(); //getting the branch details
			branch.getDoctor().add(doctor); //adding doctors to branch
			doctor.setBranch(b.get()); //setting branch to doctor
			bdao.updateBranch(branch); //update the branch
			Doctor doctor1=dao.save(doctor);//save the doctor entity
			structure.setData(doctor1);
			
			
			Person p=person.get();
			p.getDoctor().add(doctor);
			doctor.setPerson(p);
			pdao.updatePerson(person.get());
			dao.save(doctor);
			
			structure.setMesssage("doctor saved successfully");
			structure.setHttpStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Doctor>>(structure, HttpStatus.ACCEPTED);
		}
		throw  new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String >> deleteDoctor(int id)
	{
		Optional<Doctor> p=doctorRepository.findById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(p.isPresent())
		{
			dao.deleteDoctor(id);
			structure.setData("deleted");
			structure.setMesssage("deleted");
			structure.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	
	
	
}
