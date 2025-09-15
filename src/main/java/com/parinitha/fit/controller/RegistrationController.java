package com.parinitha.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.parinitha.fit.model.Person;
import com.parinitha.fit.service.PersonService;

@Controller
public class RegistrationController {
	    @Autowired
	    private PersonService personService;

	    @GetMapping("/register")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("person", new Person());
	        return "register.html";
	    }

	    @PostMapping("/createUser")
	    public String registerUser(@ModelAttribute("person") Person person) {
	        personService.registerUser(person);
	        return "redirect:/login?register=true";
	    }
}
