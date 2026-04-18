package com.cognizant.truyum.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;

@Controller
@SessionAttributes({ "userId", "customer" })
public class CartController {
	@Autowired
	CartService cartService;

	@Autowired
	MenuItemService menuItemService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "/add-to-cart")
	public String addToCart(ModelMap model, @RequestParam(value = "cutomerId") long cutomerId,
			@RequestParam(value = "menuItemId") long menuItemId) throws ParseException {
		LOGGER.info("Start add to cart ");
		// System.out.println(req.getParameter("menuItemId"));
		// System.out.println(req.getParameter("cutomerId"));
		cartService.addCartItem(cutomerId, menuItemId);
		List<MenuItem> menuItemListCustomer = menuItemService.getMenuItemListCustomer();
		// System.out.println(menuItemListCustomer);
		model.put("customer", menuItemListCustomer);
		model.put("status", true);
		LOGGER.info("End add to cart ");

		return "menu-item-list-customer";
	}

	@GetMapping(value = "/show-cart")
	public String getAllCart(ModelMap model, @RequestParam(value = "cutomerId") long userId) throws CartEmptyException {
		LOGGER.info("Start get all cart here");

		Cart cart = cartService.getAllCartItems(userId);
		List<MenuItem> cartMenuList = cart.getMenuItemList();

		if (cartMenuList.isEmpty()) {
			return "cart-empty";

		}
		model.addAttribute("cartMenuList", cart.getMenuItemList());
		model.addAttribute("total", cart.getTotal());
		model.put("status", false);
		LOGGER.info("End get all cart here");
		return "cart";

	}

	@GetMapping(value = "/remove-cart")
	public String removeCart(ModelMap model, @RequestParam(value = "cutomerId") long userId,
			@RequestParam(value = "menuItemId") long menuItemId) throws CartEmptyException {
		LOGGER.info("Start remove cart here");

		cartService.removeCartItem(userId, menuItemId);

		Cart cart = cartService.getAllCartItems(userId);
		List<MenuItem> cartMenuList = cart.getMenuItemList();
		if (cartMenuList.isEmpty()) {
			return "cart-empty";

		}
		model.addAttribute("cartMenuList", cart.getMenuItemList());
		model.addAttribute("total", cart.getTotal());

		model.put("status", true);
		LOGGER.info("Start remove inside try");
		return "cart";

	}

}
