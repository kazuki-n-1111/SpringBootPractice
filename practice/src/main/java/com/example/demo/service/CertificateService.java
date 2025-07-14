package com.example.demo.service;

import com.example.demo.form.SignInForm;
import com.example.demo.form.SignUpForm;

public interface CertificateService {
	
	void saveAdminInfo(SignUpForm signUp);
	
	SignUpForm checkEmail(SignUpForm signUp);
	
	SignInForm certificateAccount(SignInForm signIn);
}
