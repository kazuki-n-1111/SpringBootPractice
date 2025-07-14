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

import com.example.demo.entity.Contact;
import com.example.demo.form.ContactForm;
import com.example.demo.form.SignInForm;
import com.example.demo.form.SignUpForm;
import com.example.demo.service.CertificateService;
import com.example.demo.service.ContactService;
import com.example.demo.service.dto.ContactsDto;


@Controller
public class AdminController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private CertificateService certificateService;
	
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
		
		// 編集しようとしているidが存在しているかのチェック
		Contact contact = contactService.checkId(id);
		
		// 存在していたらその内容をビューに渡す。
		model.addAttribute("contactForm", contact);
			
		return "contactEdit";
	}
		
	@PostMapping("/admin/contacts/{id}/update")
	public String contactEdit(@Validated @PathVariable Long id, Model model, @ModelAttribute("contactForm") ContactForm contactForm, BindingResult errorResult,ContactsDto contactsDto) {
		if(errorResult.hasErrors()) {
			return "contactEdit";
		}
		
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
	
	
	
	// 課題３
	// 管理者の新規登録画面
	@GetMapping("/admin/signup")
	public String signUp(Model model) {
		
		model.addAttribute("signUpForm", new SignUpForm());
		
		return "signUp";
	}
	
	@PostMapping("/admin/signup")
	public String signUp(@Validated @ModelAttribute("singUpForm") SignUpForm signUp, Model model, BindingResult errorResult) {
		
		// エラーがなければ
		if(errorResult.hasErrors()) {
			return "signUp";
		}
		// emailに重複がないか確認
		SignUpForm signUpForm = certificateService.checkEmail(signUp); 
		
		// 登録処理を書く
		certificateService.saveAdminInfo(signUpForm);
		
		return "redirect:/admin/signin";
	}
	
	// 管理者のログイン画面
	@GetMapping("/admin/signin")
	public String signIn(Model model) {
		
		model.addAttribute("signInForm", new SignInForm());
		
		return "signIn";
	}
	
	@PostMapping("/admin/signin")
	public String signIn(@Validated @ModelAttribute("singInForm") SignInForm signIn, Model model, BindingResult errorResult) {
		
		// エラーがなければ
		if(errorResult.hasErrors()) {
			return "signIn";
		}
		
		//SignInForm signInForm = certificateService.checkEmail(signIn);
		certificateService.certificateAccount(signIn);
		// ログイン処理を書く
		//certificateService.certificateAccount(signIn);
		
		return "redirect:/admin/contacts";
	}

}
