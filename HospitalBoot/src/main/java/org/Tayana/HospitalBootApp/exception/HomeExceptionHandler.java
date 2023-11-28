package org.Tayana.HospitalBootApp.exception;

import org.Tayana.HospitalBootApp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HomeExceptionHandler  extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> IdNotFound(IdNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData("invalid ID ");
		structure.setMesssage(exception.getMessage());
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InvalidCredentials.class)
	public ResponseEntity<ResponseStructure<String>> InvalidCredentials(InvalidCredentials exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData("invalid Credentials ");
		structure.setMesssage(exception.getMessage());
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);	}
}
