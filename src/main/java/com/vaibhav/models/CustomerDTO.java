package com.vaibhav.models;

import javax.validation.constraints.Email;


public class CustomerDTO {
	
	private String mobileId;
	
	private String password;

	public CustomerDTO() {
	}

	private String emailId;

	public CustomerDTO(String mobileId, String password, String emailId) {
		this.mobileId = mobileId;
		this.password = password;
		this.emailId = emailId;
	}

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId( String mobileId) {
		this.mobileId = mobileId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password) {
		this.password = password;
	}

	public @Email String getEmailId() {
		return emailId;
	}

	public void setEmailId(@Email String emailId) {
		this.emailId = emailId;
	}
}
