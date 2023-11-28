package org.Tayana.HospitalBootApp.repository;

import org.Tayana.HospitalBootApp.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HopitalRepository extends JpaRepository<Hospital, Integer> {

}
