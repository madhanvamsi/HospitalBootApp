package org.Tayana.HospitalBootApp.controller;

import org.Tayana.HospitalBootApp.dto.Person;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	@Autowired
	private PersonService service;
	
	//save
	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person)
	{
		return service.savePerson(person);
	}
	
	//update
	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestBody Person person)
	{
		return service.updatePerson(person);
	}
	
	@GetMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> verifypersonByEmailAndPhone(@RequestParam String email,@RequestParam long phone)
	{
		return service.verifyPersonByEmailAndPhone(email, phone);
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity<ResponseStructure<String>> deletePerson(@PathVariable int id)
	{
		return service.deletePerson(id);
	}
	
	
}
