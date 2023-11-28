package org.Tayana.HospitalBootApp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branch_id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String area;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private long phone;
	
	//to hospital - owning side 
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;
	 
	//to doctors --  non-owning side , we write cascade attribute because it is Lazy type 
	@OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Doctor> doctor;
	
	//to encounter , we write cascade attribute because it is Lazy type 
	@OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
	@JsonIgnore           //which should ignore the other entity classes 
	private List<Encounter> encounter;

	
}
