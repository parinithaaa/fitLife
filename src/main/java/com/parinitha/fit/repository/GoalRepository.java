package com.parinitha.fit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parinitha.fit.model.Goal;
import com.parinitha.fit.model.Person;

public interface GoalRepository extends JpaRepository<Goal, Long>{
	public List<Goal> findByPerson(Person person);
}
