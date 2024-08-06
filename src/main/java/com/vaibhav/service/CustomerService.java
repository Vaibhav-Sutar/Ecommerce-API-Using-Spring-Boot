package com.vaibhav.service;

import java.util.List;

import com.vaibhav.exception.CustomerException;
import com.vaibhav.exception.CustomerNotFoundException;
import com.vaibhav.models.Address;
import com.vaibhav.models.CreditCard;
import com.vaibhav.models.Customer;
import com.vaibhav.models.CustomerDTO;
import com.vaibhav.models.CustomerUpdateDTO;
import com.vaibhav.models.Order;
import com.vaibhav.models.SessionDTO;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer getLoggedInCustomerDetails(String token) throws CustomerNotFoundException;
	
	public List<Customer> getAllCustomers(String token) throws CustomerNotFoundException;
	
	public Customer updateCustomer(CustomerUpdateDTO customer, String token) throws CustomerNotFoundException;
	
	public Customer updateCustomerMobileNoOrEmailId(CustomerUpdateDTO customerUpdateDTO, String token) throws CustomerNotFoundException;
	
	public Customer updateCreditCardDetails(String token, CreditCard card) throws CustomerException;
	
	public SessionDTO updateCustomerPassword(CustomerDTO customerDTO, String token) throws CustomerNotFoundException;
	
	public SessionDTO deleteCustomer(CustomerDTO customerDTO, String token) throws CustomerNotFoundException;
	
	public Customer updateAddress(Address address, String type, String token) throws CustomerException;
	
	public Customer deleteAddress(String type, String token) throws CustomerException, CustomerNotFoundException;

	public List<Order> getCustomerOrders(String token) throws CustomerException; 

}
