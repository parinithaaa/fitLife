package com.parinitha.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parinitha.fit.model.Contact;
import com.parinitha.fit.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {
	
	@Autowired
	private ContactRepository conrep;
	
//	@Autowired
//    public ContactService(ContactRepository contactRepository) {
//        this.conrep = contactRepository;
//    }
	
	public boolean saveMsgDetails(Contact contact) {
		boolean isSaved = true;
		conrep.save(contact);
		System.out.println(contact.toString());
		return isSaved;
	}
}
