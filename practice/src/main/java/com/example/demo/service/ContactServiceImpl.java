package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.form.ContactForm;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.dto.ContactsDto;

import jakarta.persistence.EntityNotFoundException;


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
                        e.getUpdatedAt(),
                        e.getEmail(), // 追記
                        e.getPhone(),
                        e.getZipCode(),
                        e.getAddress(),
                        e.getBuildingName(),
                        e.getBody()))
                .collect(Collectors.toList());
    }
	@Override
	public ContactsDto findDetails(Long id) {
		Optional<Contact> contactdetails = contactRepository.findById(id);
		if(contactdetails.isPresent()) {
			Contact c = contactdetails.get();
			ContactsDto details = new ContactsDto(
					c.getId(),
                    c.getLastName(),
                    c.getFirstName(),
                    c.getContactType(),
                    c.getCreatedAt(),
                    c.getUpdatedAt(),
                    c.getEmail(), // 追記
                    c.getPhone(),
                    c.getZipCode(),
                    c.getAddress(),
                    c.getBuildingName(),
                    c.getBody()
			);
			return details;
			
		}else {
			throw new EntityNotFoundException("指定されたIDのデータは見つかりませんでした: " + id);
		}
		
	}
	

}
