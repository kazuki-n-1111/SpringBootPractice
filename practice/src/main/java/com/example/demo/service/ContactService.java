package com.example.demo.service;

import java.util.List;

import com.example.demo.form.ContactForm;
//追記
import com.example.demo.service.dto.ContactsDto;

public interface ContactService {
	
	void saveContact(ContactForm contactForm);
	
	List<ContactsDto> getContactList();
	
	ContactsDto findDetails(Long id);

}
