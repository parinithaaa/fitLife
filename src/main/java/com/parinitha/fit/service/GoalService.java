package com.parinitha.fit.service;


import com.parinitha.fit.model.Goal;
import com.parinitha.fit.model.Person;
import com.parinitha.fit.repository.GoalRepository;
import com.parinitha.fit.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;
    
    @Autowired
    private PersonRepository personRepository;

    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Optional<Goal> getGoalById(Long id) {
        return goalRepository.findById(id);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
    public Goal saveGoal(Long personId, Goal goal) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        goal.setPerson(person);
        return goalRepository.save(goal);
    }

    public List<Goal> getGoalsByPerson(Long personId) {
        return goalRepository.findAll()
                .stream()
                .filter(goal -> goal.getPerson().getPersonId().equals(personId))
                .toList();
    }
}

