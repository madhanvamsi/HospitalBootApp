package org.Tayana.HospitalBootApp.dao;

import org.Tayana.HospitalBootApp.dto.Hospital;
import org.Tayana.HospitalBootApp.repository.HopitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao
{
	@Autowired
	private HopitalRepository repository;
	
	public Hospital SaveHospital(Hospital hospital)
	{
		return repository.save(hospital);
	}
	
	public Hospital updateHospital(Hospital hospital)
	{
		return repository.save(hospital);
	}
	
	public void deleteHospital(int id)
	{
		 repository.deleteById(id);
	}

}
