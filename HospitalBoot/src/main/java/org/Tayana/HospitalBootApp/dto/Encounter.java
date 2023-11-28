package org.Tayana.HospitalBootApp.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
public class Encounter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int e_id;
	@Column(nullable = false)
	private String problem;
	@CreationTimestamp
	private LocalDateTime admitTime;
	
	
	//to person
	@ManyToOne()
	@JoinColumn(name = "person_id")
	@JsonIgnore
	private Person person;
	
	//to branch
	@ManyToOne()
	@JoinColumn(name = "branch_id")
	@JsonIgnore
	private Branch branch;

}
