package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.entity.ContactDetail;
import com.example.demo.form.ContactForm;
import com.example.demo.repository.ContactRepository;
// 追記
import com.example.demo.repository.DetailRepository;
import com.example.demo.service.dto.ContactsDto;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private DetailRepository detailRepository;

	@Override
	public void saveContact(ContactForm contactForm) {
		
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
		
        return detailRepository.findAll().stream()
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
	public List<ContactsDto> findDetails(Long id) {
		
		Optional<ContactDetail> contactDetails = detailRepository.findById(id);
		if(contactDetails.isPresent()) {
			
			return detailRepository.findById(id).stream()
					.map(e -> new ContactsDto(
							e.getId(),
							e.getLastName(),
							e.getFirstName(),
							e.getContactType(),
							e.getCreatedAt(),
							e.getUpdatedAt(),
							e.getEmail(),
							e.getPhone(),
							e.getZipCode(),
							e.getAddress(),
							e.getBuildingName(),
							e.getBody()))
					.collect(Collectors.toList());

		}else {
			throw new EntityNotFoundException("指定されたIDのデータは見つかりませんでした: " + id);
		}
	}
	
	@Override
	public Contact checkId(Long id) {
		
		return contactRepository.findById(id)
			.orElseThrow(()  -> new EntityNotFoundException("指定されたIDのデータは見つかりませんでした: " + id));
		
	}
	
	
	@Override
	public Contact getDetails(Long id, ContactForm contactForm) {
		
		Contact contact = contactRepository.findById(id).orElse(null);
		
		contact.setId(contact.getId());
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
		
		return contact;
			
	}
	
	
	@Override
	public void deleteDetails(Long id) {
		
		contactRepository.deleteById(id);
			
	}
	

}
