package com.vaibhav.models;

public class SellerDTO {
	
	
	private String mobile;
	
	
	private String password;

	public  String getMobile() {
		return mobile;
	}

	public void setMobile( String mobile) {
		this.mobile = mobile;
	}

	public SellerDTO() {
	}

	public SellerDTO(String mobile, String password) {
		this.mobile = mobile;
		this.password = password;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
