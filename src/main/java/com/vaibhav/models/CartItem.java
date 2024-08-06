package com.vaibhav.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartItemId;


	public CartItem(Integer cartItemId, Product cartProduct, Integer cartItemQuantity) {
		this.cartItemId = cartItemId;
		this.cartProduct = cartProduct;
		this.cartItemQuantity = cartItemQuantity;
	}

	public CartItem() {
	}

	@OneToOne
	@JsonIgnoreProperties(value={
			"productId",
			"seller",
			"quantity"
			
	})
	private Product cartProduct;
	
	private Integer cartItemQuantity;

	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Product getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(Product cartProduct) {
		this.cartProduct = cartProduct;
	}

	public Integer getCartItemQuantity() {
		return cartItemQuantity;
	}

	public void setCartItemQuantity(Integer cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}
}
