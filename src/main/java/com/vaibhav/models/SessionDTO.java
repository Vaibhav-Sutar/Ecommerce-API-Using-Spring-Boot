package com.vaibhav.models;



public class SessionDTO {
	
	private String token;
	
	private String message;

	public SessionDTO(String token, String message) {
		this.token = token;
		this.message = message;
	}

	public SessionDTO() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
