package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Contact;
import com.example.demo.form.ContactForm;
//追記
import com.example.demo.service.dto.ContactsDto;

public interface ContactService {
	
	void saveContact(ContactForm contactForm);
	
	List<ContactsDto> getContactList();
	
	Contact checkId(Long id);
	
	List<ContactsDto> findDetails(Long id);
	
	Contact getDetails(Long id, ContactForm contactForm);
	
	// ContactsDto deleteDetails(Long id, ContactsDto contactsDto);
	void deleteDetails(Long id);
}
