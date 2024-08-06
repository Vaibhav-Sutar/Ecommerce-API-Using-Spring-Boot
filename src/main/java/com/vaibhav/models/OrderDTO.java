package com.vaibhav.models;


import javax.persistence.Embedded;


public class OrderDTO {

	public OrderDTO() {
	}

	public OrderDTO(CreditCard cardNumber, String addressType) {
		this.cardNumber = cardNumber;
		this.addressType = addressType;
	}

	public CreditCard getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(CreditCard cardNumber) {
		this.cardNumber = cardNumber;
	}

	public  String getAddressType() {
		return addressType;
	}

	public void setAddressType( String addressType) {
		this.addressType = addressType;
	}

	@Embedded
	private CreditCard cardNumber;
	private String addressType;
}
