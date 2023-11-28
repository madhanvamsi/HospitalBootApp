package org.Tayana.HospitalBootApp.dao;

import java.util.Optional;

import org.Tayana.HospitalBootApp.dto.Person;
import org.Tayana.HospitalBootApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepository repository;
	
	//save Person
	public Person savePerson(Person person)
	{
		return repository.save(person);
	}
	//update Person
	public Person updatePerson(Person person)
	{
		return repository.save(person);
	}
	
	//verify person using email and phone number
	public Optional<Person> verifyPersonByEmailAndPhone(String email,long phone)
	{
		return repository.verfiypersonByEmailAndPhone(email, phone);
	}
	
	//delete person 
	public String deletePerson(int id)
	{
		repository.deleteById(id);
		return "deleted successfully";
	}
	
	
	
	
}
