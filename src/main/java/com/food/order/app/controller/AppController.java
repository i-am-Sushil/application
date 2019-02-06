package com.food.order.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.food.order.app.service.AppService;

@Controller
@SessionAttributes("app")
public class AppController {

	@Autowired
	private AppService appService;

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		return "cart";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public String getCart(ModelMap model, @RequestParam String email, @RequestParam(required = false) String password) {
		final String cart = appService.getCart(email, password);
		model.put("cart", cart);
		return "cart";
	}

}