package com.vaibhav.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seller {
	public Integer getSellerId() {
		return sellerId;
	}

	public Seller() {
	}

	public Seller(Integer sellerId, String firstName, String lastName, String password, String mobile, String emailId, List<Product> product) {
		this.sellerId = sellerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mobile = mobile;
		this.emailId = emailId;
		this.product = product;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName( String lastName) {
		this.lastName = lastName;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword( String password) {
		this.password = password;
	}

	public  String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId( String emailId) {
		this.emailId = emailId;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sellerId;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	@Column(unique = true)
	private String mobile;
	
	
	@Column(unique = true)
	private String emailId;
	

	@OneToMany
	@JsonIgnore
	private List<Product> product;
	

}
