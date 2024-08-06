package com.vaibhav.service;

import com.vaibhav.models.CartDTO;
import com.vaibhav.models.CartItem;

public interface CartItemService {
	
	public CartItem createItemforCart(CartDTO cartdto);
	
}
