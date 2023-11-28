package org.Tayana.HospitalBootApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private long phone ;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String type;
	
	//owning side 
	@ManyToOne()
	@JoinColumn(name = "branch_id")
	@JsonIgnore
	private Branch branch;
	
	//owning side 
	@ManyToOne()
	@JoinColumn(name = "person_id")
	@JsonIgnore
	private Person person;
	
	
}
