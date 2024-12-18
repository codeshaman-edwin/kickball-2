package com.codingdojo.kickball.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	
	@NotEmpty(message = "email is required")
	@Email(message = "please enter a valid email")
	private String email;
	
	@NotEmpty(message = "password is required")
	@Size(min = 8, max = 128, message = "password must be between 8 and 128 characters")
	private String password;

	public LoginUser() {
		
	}

	public LoginUser(
			@NotEmpty(message = "email is required") @Email(message = "please enter a valid email") String email,
			@NotEmpty(message = "password is required") @Size(min = 8, max = 128, message = "password must be between 8 and 128 characters") String password) {
		
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
