package com.parinitha.fit.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parinitha.fit.model.Person;
import com.parinitha.fit.model.WaterLog;
import com.parinitha.fit.repository.WaterLogRepository;


@Service
public class WaterLogService {
	
	@Autowired
	WaterLogRepository wlr;
	
	public void addWater(Person person,int amount) {
		  WaterLog log = new WaterLog();
	       log.setPerson(person);
	        log.setDate(LocalDate.now()); 
	        log.setAmount(amount);
	        wlr.save(log);
	}
	
	public List<WaterLog> getDailyLogs(Person person) {
        List<WaterLog> logs = wlr.findByPersonAndDate(person, LocalDate.now());
        return logs;
    }

	public int getDailyTotal(Person person) {
		int i =0;
		for(WaterLog waterLog:wlr.findByPersonAndDate(person, LocalDate.now())) {
			i += waterLog.getAmount();
		}
		return i;
	}
}
