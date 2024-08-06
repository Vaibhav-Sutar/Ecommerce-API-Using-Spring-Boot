package com.vaibhav.models;

public class ProductDTO {
	
	private String prodName;
	private String manufaturer;
	private Double price;
	private Integer quantity;

	public ProductDTO() {
	}

	public ProductDTO(String prodName, String manufaturer, Double price, Integer quantity) {
		this.prodName = prodName;
		this.manufaturer = manufaturer;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getManufaturer() {
		return manufaturer;
	}

	public void setManufaturer(String manufaturer) {
		this.manufaturer = manufaturer;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
