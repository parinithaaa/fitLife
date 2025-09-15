package com.parinitha.fit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.parinitha.fit.model.Contact;

@Controller
public class LoginController {

	@RequestMapping("/logPage")
	public String display(Model model) {
		return "login.html";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "register", required = false) String register, Model model) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Email or Password is incorrect !!";
		} else if (register != null) {
			errorMessge = "You registration successful. Login with registered credentials !!";
		} else if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
		}
		System.out.println(" ");
		model.addAttribute("errorMessge", errorMessge);
		return "login.html";
	}
	
	

}
