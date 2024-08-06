package com.vaibhav.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Product {

	public Integer getProductId() {
		return productId;
	}

	public Product() {
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Product(Integer productId, String productName, Double price, String description, String manufacturer, Integer quantity, CategoryEnum category, ProductStatus status, Seller seller) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.category = category;
		this.status = status;
		this.seller = seller;
	}

	public  String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public  String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public  Integer getQuantity() {
		return quantity;
	}

	public void setQuantity( Integer quantity) {
		this.quantity = quantity;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	@NotNull
	@Size(min = 3, max = 30, message = "Product name size should be between 3-30")
	private String productName;

	@NotNull
	@DecimalMin(value = "0.00")
	private Double price;

	private String description;

	@NotNull
	private String manufacturer;

	@NotNull
	@Min(value = 0)
	private Integer quantity;

	@Enumerated(EnumType.STRING)
	private CategoryEnum category;

	@Enumerated(EnumType.STRING)
	private ProductStatus status;

//	@ManyToMany(cascade = CascadeType.ALL)
//	private Order order;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Seller seller;

//	@ManyToMany
//	@JsonIgnore
//	private List<Cart> productCarts = new ArrayList<>();

}
