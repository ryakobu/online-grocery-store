package com.cognizant.truyum.dao;

import java.text.ParseException;

public class CartDaoSqlImplTest {

	public CartDaoSqlImplTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ParseException, CartEmptyException {
		// TODO Auto-generated method stub
		CartDaoSqlImplTest.testAddCartItem();
		CartDaoSqlImplTest.testGetAllCartItems();
		CartDaoSqlImplTest.testRemoveCartItem();

	}

	public static void testAddCartItem() throws ParseException {
		CartDao cartDao=new CartDaoSqlImpl();
		cartDao.addCartItem(1, 5);
		
		

	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao=new CartDaoSqlImpl();
		
      System.out.println(cartDao.getAllCartItems(1));
	}

	public static void testRemoveCartItem() {
		CartDao cartDao=new CartDaoSqlImpl();
		cartDao.removeCartItem(2, 1);
		

	}

	

}
