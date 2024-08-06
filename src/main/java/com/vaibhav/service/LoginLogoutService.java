package com.vaibhav.service;

import com.vaibhav.models.CustomerDTO;
import com.vaibhav.models.SellerDTO;
import com.vaibhav.models.SessionDTO;
import com.vaibhav.models.UserSession;


public interface LoginLogoutService {
	
	public UserSession loginCustomer(CustomerDTO customer);
	
	public SessionDTO logoutCustomer(SessionDTO session);
	
	public void checkTokenStatus(String token);
	
	public void deleteExpiredTokens();
	
	
	public UserSession loginSeller(SellerDTO seller);
	
	public SessionDTO logoutSeller(SessionDTO session);
	
	
}
