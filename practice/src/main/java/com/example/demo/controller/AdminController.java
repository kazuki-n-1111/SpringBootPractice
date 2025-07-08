package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.ContactService;
//追記
import com.example.demo.service.dto.ContactsDto;

@Controller
public class AdminController {
	
	@Autowired
	private ContactService contactService;
	
	//課題１
	@GetMapping("/admin/contacts")
	public String contacts(Model model) {
        List<ContactsDto> contacts = contactService.getContactList();
        model.addAttribute("contactList", contacts);
        return "contactList"; // templates/contacts.html
    }

}
