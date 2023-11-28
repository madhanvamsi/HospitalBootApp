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

@Entity
@Data
public class Hospital
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospital_id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String gst;
	@Column(nullable = false)
	private String website;
	
	@OneToMany(mappedBy = "hospital" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Branch> branch;

}
