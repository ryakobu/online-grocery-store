package com.cognizant.truyum.dao;

import java.text.ParseException;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public MenuItemDaoCollectionImplTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String Args[]) throws ParseException {
		
		MenuItemDaoCollectionImplTest.testGetMenuItemListAdmin();
		
		MenuItemDaoCollectionImplTest.testGetMenuItemListCustomer();
		MenuItemDaoCollectionImplTest.testModifyMenuItem();
		MenuItemDaoCollectionImplTest.testGetMenuItem();
	}

	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao= new MenuItemDaoCollectionImpl();
		
		for(MenuItem obj:menuItemDao.getMenuItemListAdmin()) {
			System.out.println(obj);
		}
	}
	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao= new MenuItemDaoCollectionImpl();
		
		for(MenuItem obj:menuItemDao.getMenuItemListCustomer()) {
			System.out.println(obj);
		}
	}
	public static void testModifyMenuItem() throws ParseException {
		MenuItemDao menuItemDao= new MenuItemDaoCollectionImpl();
		MenuItem menuItem =new MenuItem(5, "Chocolate Brownie changed", 32.00f, true, DateUtil.convertToDate("02/11/2022"),"Deserts", true);
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println(menuItemDao.getMenuItem(5));
		
		
	}
	public static void testGetMenuItem() throws ParseException {
		MenuItemDao menuItemDao= new MenuItemDaoCollectionImpl();
		System.out.println(menuItemDao.getMenuItem(5));
		
	}
	

}
