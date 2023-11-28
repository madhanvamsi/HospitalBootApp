package org.Tayana.HospitalBootApp.repository;

import java.util.List;
import java.util.Optional;

import org.Tayana.HospitalBootApp.dto.Encounter;
import org.Tayana.HospitalBootApp.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> 
{
	@Query("select e.person from Encounter e where e.id=?1")
	Optional<List<Person>> finPersonByEncounterId(int encounter_id);
	
	@Query("select e.person from Encounter e ")
	List<Person>  filterPersonByAge();
	
}
