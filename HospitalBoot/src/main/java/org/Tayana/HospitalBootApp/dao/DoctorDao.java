package org.Tayana.HospitalBootApp.dao;


import org.Tayana.HospitalBootApp.dto.Doctor;
import org.Tayana.HospitalBootApp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDao {
	@Autowired
	private DoctorRepository repository;
	
	//save method
	public Doctor save(Doctor doctor)
	{
		return repository.save(doctor);
	}
	
	public String deleteDoctor(int id)
	{
		repository.deleteById(id);
		return "deleted successfully";
	}
	
}
