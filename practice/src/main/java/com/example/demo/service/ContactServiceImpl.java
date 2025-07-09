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
		
		Optional<ContactDetail> contactdetails = detailRepository.findById(id);
		if(contactdetails.isPresent()) {
			
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
	

}
