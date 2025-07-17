package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				// 権限設定
				.authorizeHttpRequests(authz -> authz

						// contact(お問い合わせフォーム)関連のURL、signin(ログインメニュー)、signup(管理者登録画面)については認証いらずで表示
						.requestMatchers("/admin/signin", "/contact", "/contact/confirm",
								"/contact/register", "/contact/confirm", "/contact/complete", "/admin/signup")
						.permitAll()

						// その他の画面については認証を受けている時のみアクセス可能
						.anyRequest().authenticated())

				// ログイン画面設定
				.formLogin(login -> login
						.loginPage("/admin/signin")
						.usernameParameter("email") // usernameパラメーターにemailを使用しているため
						.defaultSuccessUrl("/admin/contacts") // 認証後に自動で表示されるページURL
						.permitAll());

		return http.build();
	}
}
