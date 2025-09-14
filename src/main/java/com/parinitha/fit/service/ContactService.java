package com.parinitha.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parinitha.fit.model.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {
	public boolean saveMsgDetails(Contact contact) {
		boolean isSaved = true;
		System.out.println(contact.toString());
		return isSaved;
	}
}
