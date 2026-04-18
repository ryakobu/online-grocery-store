package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public CartDaoCollectionImplTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String Args[]) throws ParseException, CartEmptyException {
		
		CartDaoCollectionImplTest.testAddCartItem();
		CartDaoCollectionImplTest.testGetAllCartItems();
		CartDaoCollectionImplTest.testRemoveCartItem();
		
		
		
		
		
	}

	public static void testAddCartItem() throws ParseException, CartEmptyException {
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.addCartItem(1,5);
	cartDao.getAllCartItems(1);
		System.out.println(cartDao.getAllCartItems(1));

	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.getAllCartItems(1);
		System.out.println(cartDao.getAllCartItems(1));

	}

	public static void testRemoveCartItem() {
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.removeCartItem(1,5);
		 try {
			cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
