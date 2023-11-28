package org.Tayana.HospitalBootApp.dto;

import lombok.Data;

@Data
public class ResponseStructure<T>
{
	private T data;
	private String messsage;
	private int httpStatus;
	
}
