package org.Tayana.HospitalBootApp.repository;

import java.util.Optional;

import org.Tayana.HospitalBootApp.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Integer> 
{
	@Query("select p from Person p where p.email=?1 and p.phone=?2")
	Optional<Person> verfiypersonByEmailAndPhone(String email,long phone);
	
}
