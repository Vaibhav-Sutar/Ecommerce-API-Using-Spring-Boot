package com.vaibhav.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.validation.constraints.Email;


public class CustomerUpdateDTO {
	
	private String firstName;

	public CustomerUpdateDTO(String firstName, String lastName, String mobileNo, String emailId, String password, Map<String, Address> address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String firstName) {
		this.firstName = firstName;
	}

	public  String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo( String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public @Email String getEmailId() {
		return emailId;
	}

	public void setEmailId(@Email String emailId) {
		this.emailId = emailId;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword( String password) {
		this.password = password;
	}

	public Map<String, Address> getAddress() {
		return address;
	}

	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}

	public CustomerUpdateDTO() {
	}

	private String lastName;
	
	private String mobileNo;
	
	
	@Column(unique = true)
	private String emailId;
	
	private String password;
	
	private Map<String, Address> address = new HashMap<>();
	
}
