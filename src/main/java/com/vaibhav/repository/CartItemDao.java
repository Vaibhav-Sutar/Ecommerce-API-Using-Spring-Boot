package com.vaibhav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.models.CartItem;

public interface CartItemDao extends JpaRepository<CartItem, Integer>{

}
