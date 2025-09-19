package com.parinitha.fit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parinitha.fit.model.NutritionPlan;
import com.parinitha.fit.model.Person;
import com.parinitha.fit.repository.NutritionPlanRepository;

@Service
public class NutritionService {

    @Autowired
    private NutritionPlanRepository nutritionPlanRepository;

    public List<NutritionPlan> getPlans(Person person) {
        return nutritionPlanRepository.findByPerson(person);
    }

    public void savePlan(Person person, NutritionPlan plan) {
        plan.setPerson(person);
        nutritionPlanRepository.save(plan);
    }
}
