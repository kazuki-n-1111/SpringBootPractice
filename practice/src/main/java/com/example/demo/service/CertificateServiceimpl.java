package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admins;
import com.example.demo.form.SignInForm;
import com.example.demo.form.SignUpForm;
import com.example.demo.repository.CertificateRepository;


@Service
public class CertificateServiceimpl implements CertificateService {
	
	@Autowired
	private CertificateRepository certificateRepository;
	
	@Override
	public SignUpForm checkEmail(SignUpForm signUp) {
		
		if (certificateRepository.existsByEmail(signUp.getEmail())) {
		    throw new IllegalStateException("このメールアドレスは既に登録されています。");
		}else {
			return signUp;
		}
	}
	
	@Override
	public void saveAdminInfo(SignUpForm signUp) {
		
		Admins admins = new Admins();
		
		admins.setLastName(signUp.getLastName());
		admins.setFirstName(signUp.getFirstName());
		admins.setEmail(signUp.getEmail());
		admins.setPassword(signUp.getPassword());
		
		//java時間を埋め込み
		admins.setCurrentSignInAt(LocalDateTime.now());
		admins.setCreatedAt(LocalDateTime.now());
		admins.setUpdatedAt(LocalDateTime.now());
		
		certificateRepository.save(admins);
		
	}
	
	@Override
	public SignInForm certificateAccount(SignInForm signIn) {

		if (certificateRepository.existsByEmail(signIn.getEmail())) {
			
			if (certificateRepository.existsByPassword(signIn.getPassword())) {
				return signIn;
			}else {
				throw new IllegalStateException("パスワードが違います。");
			}
		    
		}else {
			throw new IllegalStateException("このメールアドレスは登録がありません。");
		}
	}

}
