package com.parinitha.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parinitha.fit.model.Person;
import com.parinitha.fit.repository.PersonRepository;
import com.parinitha.fit.service.PersonService;
import com.parinitha.fit.service.WaterLogService;

@Controller
@RequestMapping("/track")
public class WaterLogController {
	
	@Autowired
	WaterLogService waterLogService;
	
	@Autowired
	PersonRepository personRepository;
	
	@PostMapping("/water/add")
	public String addWater(@RequestParam("amount") int amount,Authentication authentication) {
		System.out.println("Inside add water controller");
		String email = authentication.getName();
		Person person = personRepository.findByEmail(email);
		waterLogService.addWater(person,amount);
		return "redirect:/dashboard";
	}
	
}
