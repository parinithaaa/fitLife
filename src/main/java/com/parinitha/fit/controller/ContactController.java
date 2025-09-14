package com.parinitha.fit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.parinitha.fit.model.Contact;
import com.parinitha.fit.service.ContactService;

import jakarta.validation.Valid;

@Controller
public class ContactController {
	@RequestMapping("/contact")
	public String display(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.html";
	}

	private final ContactService con;

	@Autowired
	public ContactController(ContactService con) {
		super();
		this.con = con;
	}

	@RequestMapping(value = "/formSubmit", method = POST)
	public String saveMessage(@Valid @ModelAttribute("contact") Contact contact,Errors errors) {
		if (errors.hasErrors()) {
			System.out.println("Validation failed: " + errors.getAllErrors());
			return "contact.html";
		}
		con.saveMsgDetails(contact);
		return "redirect:/contact";
	}

}
