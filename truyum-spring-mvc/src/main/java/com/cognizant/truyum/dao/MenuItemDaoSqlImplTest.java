package com.cognizant.truyum.dao;

import java.text.ParseException;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public MenuItemDaoSqlImplTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		// menuItemDao.getMenuItemListAdmin();
		//MenuItemDaoSqlImplTest.testGetMenuItemListAdmin();
		//MenuItemDaoSqlImplTest.testGetMenuItemListCustomer();
		//MenuItemDaoSqlImplTest.testGetMenuItem();
		MenuItemDaoSqlImplTest.testModifyMenuItem();

	}

	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		for (MenuItem obj : menuItemDao.getMenuItemListAdmin()) {
			System.out.println(obj);
		}

	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		for (MenuItem obj : menuItemDao.getMenuItemListCustomer()) {
			System.out.println(obj);
		}

	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
		MenuItem menuItem =new MenuItem(5, "Chocolate Brownie changed", 32.00f, true, DateUtil.convertToDate("02/11/2022"),"Deserts", true);
		menuItemDao.editMenuItem(menuItem);
		

	}

	public static void testGetMenuItem() {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		System.out.println(menuItemDao.getMenuItem(3));
		
		

	}

}
