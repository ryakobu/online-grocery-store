package com.cognizant.truyum.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.MenuItemForm;
@Component
public class MenuItemFormService {

	public MenuItemFormService() {
		// TODO Auto-generated constructor stub
	}
   
	public MenuItem convertToMenuItem(MenuItemForm menuItemForm ) throws ParseException {
		MenuItem menuItem=new MenuItem();
		menuItem.setId(menuItemForm.getId());
		menuItem.setName(menuItemForm.getName());
		menuItem.setPrice(menuItemForm.getPrice());
		menuItem.setActive(menuItemForm.isActive());
		menuItem.setDateOfLaunch(new SimpleDateFormat("yyyy-MM-dd").parse(menuItemForm.getDateOfLaunch()));
		menuItem.setCategory(menuItemForm.getCategory());
		menuItem.setFreeDelivery(menuItemForm.isFreeDelivery());
		return menuItem;
		
	}
}
