package com.vaibhav.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	public Customer() {
	}

	public Customer(Integer customerId, String firstName, String lastName, String mobileNo, String emailId, String password, LocalDateTime createdOn, CreditCard creditCard, Map<String, Address> address, List<Order> orders, Cart customerCart) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
		this.createdOn = createdOn;
		this.creditCard = creditCard;
		this.address = address;
		this.orders = orders;
		this.customerCart = customerCart;
	}

	private String firstName;
	
	private String lastName;
	
	@Column(unique = true)
	private String mobileNo;
	
	
	@Column(unique = true)
	private String emailId;
	
	private String password;
	
	
	private LocalDateTime createdOn;
	
	@Embedded
	private CreditCard creditCard;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_address_mapping",
				joinColumns = {
						@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
				},
				inverseJoinColumns = {
						@JoinColumn(name = "address_id", referencedColumnName = "addressId")
				})
	private Map<String, Address> address = new HashMap<>();
	
	

	
	
//	Establishing Customer - Order relationship
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Order> orders = new ArrayList<>();
	
	
	
//	Establishing Customer - Cart relationship
//	
@OneToOne(cascade = CascadeType.ALL)
private Cart customerCart;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public  String getFirstName() {
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo( String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public  String getEmailId() {
		return emailId;
	}

	public void setEmailId( String emailId) {
		this.emailId = emailId;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Map<String, Address> getAddress() {
		return address;
	}

	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Cart getCustomerCart() {
		return customerCart;
	}

	public void setCustomerCart(Cart customerCart) {
		this.customerCart = customerCart;
	}
}
