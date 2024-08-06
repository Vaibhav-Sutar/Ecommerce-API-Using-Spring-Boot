package com.vaibhav.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.exception.LoginException;
import com.vaibhav.exception.SellerNotFoundException;
import com.vaibhav.models.Customer;
import com.vaibhav.models.CustomerDTO;
import com.vaibhav.models.Seller;
import com.vaibhav.models.SellerDTO;
import com.vaibhav.models.SessionDTO;
import com.vaibhav.models.UserSession;
import com.vaibhav.repository.CustomerDao;
import com.vaibhav.repository.SellerDao;
import com.vaibhav.repository.SessionDao;

@Service
public class LoginLogoutServiceImpl implements LoginLogoutService{

	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SellerDao sellerDao;

 
	
	// Method to login a customer

	@Override
	public UserSession loginCustomer(CustomerDTO loginCustomer) {
		System.out.println(loginCustomer);
		System.out.println(loginCustomer.getMobileId());
		System.out.println(loginCustomer.getEmailId());
		System.out.println(loginCustomer.getPassword());

		Optional<Customer> res = customerDao.findByMobileNo(loginCustomer.getMobileId());
		System.out.println(res.get().getEmailId());
		//if(res.isPresent())
		//	throw new CustomerNotFoundException("Customer record does not exist with given mobile number");
		
		Customer existingCustomer = res.get();
		
		Optional<UserSession> opt = sessionDao.findByUserId(existingCustomer.getCustomerId());
		
		if(opt.isPresent()) {
			
			UserSession user = opt.get();
			
			if(user.getSessionEndTime().isBefore(LocalDateTime.now())) {
				sessionDao.delete(user);	
			}
			else
				throw new LoginException("User already logged in");
			
		}
		
		
		if(existingCustomer.getPassword().equals(loginCustomer.getPassword())) {
		
			UserSession newSession = new UserSession();
			
			newSession.setUserId(existingCustomer.getCustomerId());
			newSession.setUserType("customer");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));
			
			UUID uuid = UUID.randomUUID();
			String token = "customer_" + uuid.toString().split("-")[0];
			
			newSession.setToken(token);
			
			return sessionDao.save(newSession);
		}
		else {
			throw new LoginException("Password Incorrect. Try again.");
		}
	}

	
	// Method to logout a customer
	
	@Override
	public SessionDTO logoutCustomer(SessionDTO sessionToken) {
		
		String token = sessionToken.getToken();
		
		checkTokenStatus(token);
		
		Optional<UserSession> opt = sessionDao.findByToken(token);
		
		if(!opt.isPresent())
			throw new LoginException("User not logged in. Invalid session token. Login Again.");
		
		UserSession session = opt.get();
		
		sessionDao.delete(session);
		
		sessionToken.setMessage("Logged out sucessfully.");
		
		return sessionToken;
	}
	
	
	
	// Method to check status of session token
	
	
	@Override
	public void checkTokenStatus(String token) {
		
		Optional<UserSession> opt = sessionDao.findByToken(token);
		
		if(opt.isPresent()) {
			UserSession session = opt.get();
			LocalDateTime endTime = session.getSessionEndTime();
			boolean flag = false;
			if(endTime.isBefore(LocalDateTime.now())) {
				sessionDao.delete(session);
				flag = true;
			}
			
			deleteExpiredTokens();
			if(flag)
				throw new LoginException("Session expired. Login Again");
		}
		else {
			throw new LoginException("User not logged in. Invalid session token. Please login first.");
		}
		
	}

	
	// Method to login a valid seller and generate a seller token
	
	@Override
	public UserSession loginSeller(SellerDTO seller) {
		
		Optional<Seller> res = sellerDao.findByMobile(seller.getMobile());
		
		if(res.isPresent())
			throw new SellerNotFoundException("Seller record does not exist with given mobile number");
		
		Seller existingSeller = res.get();
		
		Optional<UserSession> opt = sessionDao.findByUserId(existingSeller.getSellerId());
		
		if(opt.isPresent()) {
			
			UserSession user = opt.get();
			
			if(user.getSessionEndTime().isBefore(LocalDateTime.now())) {
				sessionDao.delete(user);	
			}
			else
				throw new LoginException("User already logged in");
			
		}
		
		
		if(existingSeller.getPassword().equals(seller.getPassword())) {
		
			UserSession newSession = new UserSession();
			
			newSession.setUserId(existingSeller.getSellerId());
			newSession.setUserType("seller");
			newSession.setSessionStartTime(LocalDateTime.now());
			newSession.setSessionEndTime(LocalDateTime.now().plusHours(1));
			
			UUID uuid = UUID.randomUUID();
			String token = "seller_" + uuid.toString().split("-")[0];
			
			newSession.setToken(token);
			
			return sessionDao.save(newSession);
		}
		else {
			throw new LoginException("Password Incorrect. Try again.");
		}
	}

	
	// Method to logout a seller and delete his session token
	
	@Override
	public SessionDTO logoutSeller(SessionDTO session) {
		
		String token = session.getToken();
		
		checkTokenStatus(token);
		
		Optional<UserSession> opt = sessionDao.findByToken(token);
		
		if(!opt.isPresent())
			throw new LoginException("User not logged in. Invalid session token. Login Again.");
		
		UserSession user = opt.get();
		
		sessionDao.delete(user);
		
		session.setMessage("Logged out sucessfully.");
		
		return session;
	}
	
	
	// Method to delete expired tokens
	
	@Override
	public void deleteExpiredTokens() {
		
		System.out.println("Inside delete tokens");
		
		List<UserSession> users = sessionDao.findAll();
		
		System.out.println(users);
		
		if(users.size() > 0) {
			for(UserSession user:users) {
				System.out.println(user.getUserId());
				LocalDateTime endTime = user.getSessionEndTime();
				if(endTime.isBefore(LocalDateTime.now())) {
					System.out.println(user.getUserId());
					sessionDao.delete(user);
				}
			}
		}
	}
	
}
