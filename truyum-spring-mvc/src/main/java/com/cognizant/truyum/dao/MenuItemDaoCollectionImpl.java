package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static  List<MenuItem> menuItemList;


	public MenuItemDaoCollectionImpl() throws ParseException {
		// TODO Auto-generated constructor stub
		
		if(menuItemList==null) {
			menuItemList=new ArrayList<>();
			menuItemList.add(new MenuItem(1, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),"Main Course", true));
			menuItemList.add(new MenuItem(2, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"),"Main Course", false));
			menuItemList.add(new MenuItem(3, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2017"),"Main Course", false));
			menuItemList.add(new MenuItem(4, "French Fries", 57.00f, false, DateUtil.convertToDate("02/07/2017"),"Starters", true));
			menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"),"Deserts", true));
			
		}
		else {
			
		}
		
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		ArrayList<MenuItem> menuItemListCustomer=new ArrayList<>();
		Date currentDate=new Date();
		for(MenuItem obj:menuItemList) {
			//System.out.println(obj);
			if(obj.getDateOfLaunch().compareTo(currentDate)<0 &&  obj.isActive()) {
				
				menuItemListCustomer.add(obj);

				//System.out.println(obj);
			}
			
			
		}
		
		
		
		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for (MenuItem obj : menuItemList) {
			if (obj.getId()==menuItem.getId())
				menuItemList.set((int) (obj.getId() - 1), menuItem);
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for (MenuItem obj : menuItemList) {
			if (obj.getId()==menuItemId){
				return obj;
			}
				
		}
	
		return null;
		
		
	}

}
