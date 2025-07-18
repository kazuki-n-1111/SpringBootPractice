package com.example.demo.authentication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.repository.CertificateRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	//リポジトリ
	private final CertificateRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// Emailに一致したレコードを探し、なければexceptionを発行
		var userInfo = repository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));

		// Email,Passwordをそれぞれ比較
		return User.withUsername(userInfo.getEmail())
				.password(userInfo.getPassword())
				.roles("USER")
				.build();
	}

}
