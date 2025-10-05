package com.parinitha.fit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parinitha.fit.model.Person;
import com.parinitha.fit.model.WaterLog;

@Repository
public interface WaterLogRepository extends JpaRepository<WaterLog, Long> {
	List<WaterLog> findByPersonAndDate(Person person,LocalDate date);
}
