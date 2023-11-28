package org.Tayana.HospitalBootApp.controller;

import java.util.List;
import org.Tayana.HospitalBootApp.dto.Encounter;
import org.Tayana.HospitalBootApp.dto.Person;
import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.Tayana.HospitalBootApp.service.EncounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncounterController {
	@Autowired
	private EncounterService service;
	
	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter
			,@RequestParam int branch_id,
			@RequestParam int person_id)
	{
		return service.saveEncounter(encounter, branch_id, person_id);
	}
	
	@GetMapping("/encounter/{encounter_id}")
	public ResponseEntity<ResponseStructure<List<Person>>> findPersonByEncounterId(@PathVariable int encounter_id)
	{
		return service.findPersonByEncounterId(encounter_id);
	}
	
	@DeleteMapping("/encounter/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEncounter(@PathVariable int id)
	{
		return service.deleteEncounter(id);
	}
	
	@GetMapping("/personss")
	public ResponseEntity<ResponseStructure<List<Person>>> filterPersonByAge()
	{
		return service.filterPersonByAge();
	}
	
}
