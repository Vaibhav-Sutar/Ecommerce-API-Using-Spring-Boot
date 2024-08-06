package com.vaibhav.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	@PastOrPresent
	private LocalDate date;

	public Order() {
	}

	public Order(Integer orderId, LocalDate date, OrderStatusValues orderStatus, Double total, String cardNumber, Customer customer, List<CartItem> ordercartItems, Address address) {
		this.orderId = orderId;
		this.date = date;
		this.orderStatus = orderStatus;
		this.total = total;
		this.cardNumber = cardNumber;
		this.customer = customer;
		this.ordercartItems = ordercartItems;
		this.address = address;
	}

	public OrderStatusValues getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusValues orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public @PastOrPresent LocalDate getDate() {
		return date;
	}

	public void setDate(@PastOrPresent LocalDate date) {
		this.date = date;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItem> getOrdercartItems() {
		return ordercartItems;
	}

	public void setOrdercartItems(List<CartItem> ordercartItems) {
		this.ordercartItems = ordercartItems;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	private OrderStatusValues orderStatus;
	
	private Double total;
	
	private String cardNumber;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	@OneToMany
	private List<CartItem> ordercartItems = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private Address address;
}
