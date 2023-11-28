package org.Tayana.HospitalBootApp.repository;

import java.util.Optional;

import org.Tayana.HospitalBootApp.dto.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch, Integer>
{
	@Query("select b from Branch b where b.hospital.hospital_id=?1")
	Optional<Branch> findBranchByHospitalId(int hospital_id);

}
