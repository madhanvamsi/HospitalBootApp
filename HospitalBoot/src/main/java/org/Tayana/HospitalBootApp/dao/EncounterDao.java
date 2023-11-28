package org.Tayana.HospitalBootApp.dao;

import java.util.List;
import java.util.Optional;

import org.Tayana.HospitalBootApp.dto.Encounter;
import org.Tayana.HospitalBootApp.dto.Person;
import org.Tayana.HospitalBootApp.repository.EncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EncounterDao 
{
	@Autowired
	private EncounterRepository repository;
	
	//save Encounter
	public Encounter saveEncounter(Encounter encounter)
	{
		return repository.save(encounter);
	}
	
	//update Encounter
	public Encounter updateEncounter(Encounter encounter)
	{
		return repository.save(encounter);
	}
	
	//find person Through Encounter ID                     
	public Optional<List<Person>> finPersonByEncounterId(int encounter_id)
	{
		return repository.finPersonByEncounterId(encounter_id);
	}
	
	//delete Encounter
	public String deleteEnconter(int Encounter_id)
	{
		Optional<Encounter> e=	repository.findById(Encounter_id);
		if(e.isPresent())
		{
			repository.deleteById(Encounter_id);
			return "deleted";
		}
		else
			return "invalid id ";
	}
	
	public List<Person>  filterPersonByAge( )
	{
		return repository.filterPersonByAge();
	}
}
