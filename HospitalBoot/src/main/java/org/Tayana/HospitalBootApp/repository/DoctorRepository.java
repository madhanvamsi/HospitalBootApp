package org.Tayana.HospitalBootApp.repository;

import org.Tayana.HospitalBootApp.dto.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{
	
}
