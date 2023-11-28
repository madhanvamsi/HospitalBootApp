 package org.Tayana.HospitalBootApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.Tayana.HospitalBootApp.dao.BranchDao;
import org.Tayana.HospitalBootApp.dao.EncounterDao;
import org.Tayana.HospitalBootApp.dao.PersonDao;
import org.Tayana.HospitalBootApp.dto.Branch;
import org.Tayana.HospitalBootApp.dto.Encounter;
import org.Tayana.HospitalBootApp.dto.Person;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.exception.IdNotFoundException;
import org.Tayana.HospitalBootApp.exception.InvalidCredentials;
import org.Tayana.HospitalBootApp.repository.BranchRepository;
import org.Tayana.HospitalBootApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EncounterService 
{
	@Autowired
	private EncounterDao edao;
	@Autowired
	private BranchRepository repository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private BranchDao bdao;
	@Autowired
	private PersonDao pdao;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter,int branch_id,int person_id)
	{
		Optional<Branch> branch	=repository.findById(branch_id); //fetching details of branch through branch_id
		Optional<Person> person=personRepository.findById(person_id); //fetching details of person through person_id
		ResponseStructure<Encounter> structure=new ResponseStructure<Encounter>();
	if(branch.isPresent() && person.isPresent()) //both are present only
	{
		Branch b= branch.get(); //fetching branch details through branch_id
		b.getEncounter().add(encounter); //adding List<encounter> to branch
		encounter.setBranch(b); //setting branch to encounter
		bdao.updateBranch(branch.get());
		edao.saveEncounter(encounter);
		
		
		Person p= person.get();  //fetching  person details through Person_id 
		p.getEncounter().add(encounter); //adding a List<encounter> to person
		encounter.setPerson(p); //setting person to encounter
		pdao.updatePerson(person.get()); //update person
		edao.saveEncounter(encounter); //save Encounter
		
		structure.setData(encounter);  
		structure.setMesssage("Encounter saved successfully");
		structure.setHttpStatus(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.ACCEPTED);
		//returns body and some HttpResponse
	}
		throw  new IdNotFoundException(); //throwing the exception and handling the exception in exception package

	}
	
	//find person through Encounter Id
	public ResponseEntity<ResponseStructure<List<Person>>> findPersonByEncounterId(int encounter_id)
	{
		ResponseStructure<List<Person>> structure=new ResponseStructure<List<Person>>();
		Optional<List<Person>> person=edao.finPersonByEncounterId(encounter_id);
		if(person.isPresent())
		{
			structure.setData(person.get());
			structure.setMesssage("found person with given encounter id ");
			structure.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.OK);
			
		}
		else
		{
			throw new InvalidCredentials(); // Exception 
		}
		
	}
	
	//delete through Encounter Id
	public ResponseEntity<ResponseStructure<String>> deleteEncounter(int E_id)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		edao.deleteEnconter(E_id);
		structure.setData("deleted");
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setMesssage("deleted successfully");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<List<Person>>> filterPersonByAge()
	{
		ResponseStructure<List<Person>> structure=new ResponseStructure<List<Person>>();
		
			structure.setData(edao.filterPersonByAge()
					.stream().filter(pers->pers.getAge()>18) //filtering the person data whose age is above 18
					.collect(Collectors.toList())); //Collecting the data in a list 
			structure.setMesssage("found person with above age 18 ");
			structure.setHttpStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure,HttpStatus.OK);
			
	}
	
}
	



