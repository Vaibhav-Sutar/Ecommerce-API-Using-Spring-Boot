package com.vaibhav.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	private String streetNo;
	
	private String buildingName;
	
	private String locality;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo( String streetNo) {
		this.streetNo = streetNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName( String buildingName) {
		this.buildingName = buildingName;
	}

	public  String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public  String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public  String getState() {
		return state;
	}

	public void setState( String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address() {
	}

	public Address(Integer addressId, String streetNo, String buildingName, String locality, String city, String state, String pincode, Customer customer) {
		this.addressId = addressId;
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.customer = customer;
	}
}
