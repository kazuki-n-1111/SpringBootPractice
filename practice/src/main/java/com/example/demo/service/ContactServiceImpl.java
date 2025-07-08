package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.form.ContactForm;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.dto.ContactsDto;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void saveContact(ContactForm contactForm) {
		// TODO 自動生成されたメソッド・スタブ
		
		Contact contact = new Contact();
		
		contact.setLastName(contactForm.getLastName());
		contact.setFirstName(contactForm.getFirstName());
		contact.setEmail(contactForm.getEmail());
		contact.setPhone(contactForm.getPhone());
		contact.setZipCode(contactForm.getZipCode());
		contact.setAddress(contactForm.getAddress());
		contact.setBuildingName(contactForm.getBuildingName());
		contact.setContactType(contactForm.getContactType());
		contact.setBody(contactForm.getBody());
		
		contactRepository.save(contact);
	}
	
	@Override
    public List<ContactsDto> getContactList() {
        return contactRepository.findAll().stream()
                .map(e -> new ContactsDto(
                        e.getId(),
                        e.getLastName(),
                        e.getFirstName(),
                        e.getContactType(),
                        e.getCreatedAt(),
                        e.getUpdatedAt()))
                .collect(Collectors.toList());
    }

}
