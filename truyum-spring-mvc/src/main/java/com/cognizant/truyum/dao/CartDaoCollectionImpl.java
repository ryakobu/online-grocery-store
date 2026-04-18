package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		// TODO Auto-generated constructor stub
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();

		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) throws ParseException {
		// TODO Auto-generated method stub
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		;
		boolean status = false;

		for (Long obj : userCarts.keySet()) {
			if (obj == userId) {
				status = true;
				break;
			}

		}
		if (status) {
			userCarts.get(userId).getMenuItemList().add(menuItemDao.getMenuItem(menuItemId));
		} else {
			Cart cart = new Cart();
			List<MenuItem> menuItemList = new ArrayList<>();
			menuItemList.add(menuItemDao.getMenuItem(menuItemId));
			cart.setMenuItemList(menuItemList);
			userCarts.put(userId, cart);

		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		
		if (userCarts.get(userId).getMenuItemList().isEmpty()) {
			throw new CartEmptyException("cart is empty");

		} else {
			double total = 0;
			for (MenuItem obj : userCarts.get(userId).getMenuItemList()) {
				total = total + obj.getPrice();

			}

			userCarts.get(userId).setTotal(total);
		}

		return userCarts.get(userId);
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		for (MenuItem obj : userCarts.get(userId).getMenuItemList()) {
			if (obj.getId() == menuItemId) {
				userCarts.get(userId).getMenuItemList().remove(obj);
				break;
			}
		}

	}

}
