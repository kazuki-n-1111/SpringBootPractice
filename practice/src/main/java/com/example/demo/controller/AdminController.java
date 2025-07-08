package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 追記
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;
import com.example.demo.service.dto.ContactsDto;

@Controller
public class AdminController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping("/admin/contacts")
	public String contacts(Model model) {
        List<ContactsDto> contacts = contactService.getContactList();
        model.addAttribute("contactList", contacts);
        return "contactList"; 
    }
	
	// 課題2
	@GetMapping("/admin/contacts/{id}")
	public String contactdetail(@PathVariable Long id, Model model) {
		ContactsDto detail = contactService.findDetails(id); 
        model.addAttribute("contactDetails", detail);
        return "contactDetails"; 
    }

}
