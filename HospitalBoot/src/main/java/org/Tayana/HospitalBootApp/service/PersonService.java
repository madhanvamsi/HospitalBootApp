package org.Tayana.HospitalBootApp.service;


import java.util.Optional;

import org.Tayana.HospitalBootApp.dao.PersonDao;
import org.Tayana.HospitalBootApp.dto.Person;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.exception.IdNotFoundException;
import org.Tayana.HospitalBootApp.exception.InvalidCredentials;
import org.Tayana.HospitalBootApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class PersonService 
{
	@Autowired
	private PersonDao pdao;
	@Autowired
	private PersonRepository repository;
	
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person)
	{
		ResponseStructure<Person> structure=new ResponseStructure<>();
		structure.setData(pdao.savePerson(person));
		structure.setMesssage("hospital saved successfully");
		structure.setHttpStatus(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.ACCEPTED);
	
	}
	
	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person person)
	{
		ResponseStructure<Person> structure=new ResponseStructure<>();
		structure.setData(pdao.updatePerson(person));
		structure.setMesssage("hospital updated successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.CREATED);
	
	}
	
	public ResponseEntity<ResponseStructure<Person >> verifyPersonByEmailAndPhone(String email,long phone )
	{
		ResponseStructure<Person> structure=new ResponseStructure<Person>();
		Optional<Person> enc=pdao.verifyPersonByEmailAndPhone(email, phone);
		if(enc.isPresent())
		{
			structure.setData(enc.get());
			structure.setMesssage("Found");
			structure.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		}
		else
		{
			throw new InvalidCredentials();
		}
	}
	
	public ResponseEntity<ResponseStructure<String >> deletePerson(int id)
	{
		Optional<Person> p=repository.findById(id);
		ResponseStructure<String> structure=new ResponseStructure<String>();
		if(p.isPresent())
		{
			pdao.deletePerson(id);
			structure.setData("deleted");
			structure.setMesssage("deleted");
			structure.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	
	
 }
	
	
