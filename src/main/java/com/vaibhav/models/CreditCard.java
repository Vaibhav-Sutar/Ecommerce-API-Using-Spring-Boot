package com.vaibhav.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class CreditCard {
	
	@Pattern(regexp = "[0-9]{16,18}", message = "Invalid card number")
	@NotNull
	private String cardNumber;
	
	private String cardValidity;
	
	private String cardCVV;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber( String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public  String getCardValidity() {
		return cardValidity;
	}

	public void setCardValidity( String cardValidity) {
		this.cardValidity = cardValidity;
	}

	public CreditCard() {
	}

	public CreditCard(String cardNumber, String cardValidity, String cardCVV) {
		this.cardNumber = cardNumber;
		this.cardValidity = cardValidity;
		this.cardCVV = cardCVV;
	}

	public  String getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV( String cardCVV) {
		this.cardCVV = cardCVV;
	}
}
