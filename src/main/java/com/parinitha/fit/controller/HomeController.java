package com.parinitha.fit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public ModelAndView firstView(Model model) {
		ModelAndView modelview = new ModelAndView("home.html");
		return modelview;
	}
}
