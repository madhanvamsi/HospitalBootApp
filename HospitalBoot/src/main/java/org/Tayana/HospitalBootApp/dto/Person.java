package org.Tayana.HospitalBootApp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private long phone;
	@Column(nullable = false)
	private int age;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Encounter> encounter;

	@OneToMany(mappedBy = "person" ,cascade = CascadeType.ALL)
	private List<Doctor> doctor;
	

}
