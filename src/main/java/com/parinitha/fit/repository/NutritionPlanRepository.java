package com.parinitha.fit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parinitha.fit.model.NutritionPlan;
import com.parinitha.fit.model.Person;

public interface NutritionPlanRepository extends JpaRepository<NutritionPlan, Long> {
	List<NutritionPlan> findByPerson(Person person);
}
