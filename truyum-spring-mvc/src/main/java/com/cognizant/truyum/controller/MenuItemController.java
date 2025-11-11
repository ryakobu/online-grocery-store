package com.cognizant.truyum.controller;

import java.text.ParseException;
import java.util.List;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.MenuItemForm;
import com.cognizant.truyum.service.MenuItemFormService;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	MenuItemFormService menuItemFormService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping("/show-menu-list-admin")

	public String showMenuItemListAdmin(ModelMap model) {
		LOGGER.info("START show-menu-list-admin");
		List<MenuItem> menulist = menuItemService.getMenuItemListAdmin();
		// System.out.println(menulist);
		model.put("admin", menulist);

		LOGGER.info("END show-menu-list-admin");

		return "menu-item-list-admin";

	}

	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) {
		LOGGER.info("START show-menu-list-customer");
		List<MenuItem> menuItemListCustomer = menuItemService.getMenuItemListCustomer();
		// System.out.println(menuItemListCustomer);
		model.put("customer", menuItemListCustomer);
		model.put("status", false);
		// System.out.println(model.get("name"));;

		LOGGER.info("END show-menu-list-customer");

		return "menu-item-list-customer";

	}

	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(ModelMap model, @RequestParam(value = "menuItemId") long menuItemId) {
		LOGGER.info("START showEditMenuItem");
		// System.out.println(menuItemId);
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		model.addAttribute("menuItem", menuItem);
		MenuItemForm menuItemForm = new MenuItemForm();
		model.addAttribute("modifiedMenuItem", menuItemForm);
		LOGGER.info("END showEditMenuItem");

		return "edit-menu-item";

	}

	@PostMapping("/edit-menu-item")
	public String editMenuItem(@Valid @ModelAttribute("modifiedMenuItem") MenuItemForm menuItemForm,
			BindingResult result) {
		LOGGER.info("Start edit menu item page");

		// System.out.println(menuItemForm);
		if (result.hasErrors()) {
			return "edit-menu-item";
		}
		MenuItem menuItem = new MenuItem();
		try {
			menuItem = menuItemFormService.convertToMenuItem(menuItemForm);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(menuItemForm);

		// System.out.println(menuItem);

		menuItemService.modifyMenuItem(menuItem);
		LOGGER.info("End edit menu item page");
		return "edit-menu-item-status";

	}
	@GetMapping("/")
	public String homePage(ModelMap model) {
		LOGGER.info("START homePage");
		
		
		LOGGER.info("END homePage");

		return "home";

	}
	
}
