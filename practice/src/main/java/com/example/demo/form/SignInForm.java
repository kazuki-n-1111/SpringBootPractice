package com.example.demo.form;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class SignInForm implements Serializable {

	@Email
	@NotBlank
	private String email;
	
	
	@NotBlank
	private String password;
	
}
