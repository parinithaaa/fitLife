package com.parinitha.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parinitha.fit.model.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
