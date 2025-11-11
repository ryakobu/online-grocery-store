package com.cognizant.truyum.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
public class CartService{
	@Autowired
	@Qualifier("cartDaoSqlImpl")
	private CartDao cartDao;

	public void addCartItem(long userId,long menuItemId) throws ParseException {
		cartDao.addCartItem(userId, menuItemId);
	}
	
	public Cart  getAllCartItems(long userId) throws CartEmptyException {
		Cart cart=cartDao.getAllCartItems(userId);
		
		
		return cart;
		
	}
	 public void removeCartItem(long userId,long menuItemId){
		 
		 cartDao.removeCartItem(userId, menuItemId);
		 
		 
	 }
}