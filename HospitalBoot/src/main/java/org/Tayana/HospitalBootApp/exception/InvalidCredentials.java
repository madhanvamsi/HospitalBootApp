package org.Tayana.HospitalBootApp.exception;

public class InvalidCredentials extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "invalid credentials";
	}

}
