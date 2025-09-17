package com.parinitha.fit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parinitha.fit.model.Goal;
import com.parinitha.fit.model.Person;
import com.parinitha.fit.repository.PersonRepository;
import com.parinitha.fit.service.GoalService;
import com.parinitha.fit.service.NutritionService;

@Controller
public class DashboardController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private GoalService goalService;
	
//	@Autowired
//    private NutritionService nutritionService;

	
	@GetMapping("/dashboard")
	public String dashboard(Authentication authentication, Model model) {
	    String email = authentication.getName();
	    Person person = personRepository.findByEmail(email);

	    if (person != null) {
	        model.addAttribute("username", person.getName());
	        model.addAttribute("email", person.getEmail());
	        model.addAttribute("goal", "Stay Fit");
	    }
	    return "dashboard";
	}
	
	
	@GetMapping("/dashboard/updateDetails")
	public String showUpdateForm(Model model, Authentication authentication) {
	    String email = authentication.getName();
	    Person person = personRepository.findByEmail(email);
	    model.addAttribute("person", person);
	    return "update-details";
	}

	@PostMapping("/dashboard/updateDetails")
	public String updateDetails(@ModelAttribute Person updatedPerson, Authentication authentication) {
	    String email = authentication.getName();
	    Person person = personRepository.findByEmail(email);

	    if (person != null) {
	        person.setName(updatedPerson.getName());
	        person.setAge(updatedPerson.getAge());
	        person.setHeight(updatedPerson.getHeight());
	        person.setWeight(updatedPerson.getWeight());
	        personRepository.save(person);
	    }

	    return "redirect:/dashboard";
	}


//    @GetMapping
//    public String showDashboard(Principal principal, Model model) {
//        // get logged-in user email from principal
//        String email = principal.getName();
//        // fetch goals for that user
//        // (we’ll link email → personId later if needed)
//        List<Goal> goals = goalService.getGoalsByPerson(1L); // for now assume personId=1
//        model.addAttribute("goals", goals);
//        return "dashboard";
//    }
//
    @PostMapping("/goals")
    public String addGoal(@ModelAttribute Goal goal, Principal principal) {
        // later we’ll fetch personId from logged-in email
        goalService.saveGoal(1L, goal);
        return "redirect:/dashboard";
    }
}
