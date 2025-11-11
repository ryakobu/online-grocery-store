package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	public void addCartItem(long userId,long menuItemId) throws ParseException;
	public Cart  getAllCartItems(long userId) throws CartEmptyException;
   public void removeCartItem(long userId,long menuItemId);
}
