package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ContactForm;
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
	// 管理者詳細画面表示
	@GetMapping("/admin/contacts/{id}")
	public String contactdetail(@PathVariable Long id, Model model) {
		List<ContactsDto> detail = contactService.findDetails(id); 
        model.addAttribute("contactDetails", detail);
        return "contactDetails"; 
    }
	
	// 管理者編集画面
	@GetMapping("/admin/contacts/{id}/edit")
	public String contactEdit(@PathVariable Long id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("contactForm", new ContactForm());
			
		return "contactEdit";
	}
		
	@PostMapping("/admin/contacts/{id}/update")
	public String contactEdit(@Validated @PathVariable Long id, Model model, @ModelAttribute("contactForm") ContactForm contactForm, BindingResult errorResult,ContactsDto contactsDto) {
		if(errorResult.hasErrors()) {
			return "contactEdit";
		}
		// 更新情報をcontactFormに入れる
		//model.addAttribute("contactForm", contactForm);
		
		contactService.getDetails(id, contactForm);
			
		// 管理者詳細画面へリダイレクト
		return "redirect:/admin/contacts/" + id;
	}
	
	@PostMapping("/admin/contacts/{id}/delete")
	public String deleteEdit(@PathVariable Long id) {
		
		contactService.deleteDetails(id);
			
		// 管理者詳細画面へリダイレクト
		return "redirect:/admin/contacts/" + id;
	}
	
	

}
