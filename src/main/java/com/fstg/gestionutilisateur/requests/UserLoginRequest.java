package com.fstg.gestionutilisateur.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginRequest {


	@NotBlank(message = "Ce champs ne doit pas etre null")
	@Email(message = "email ne coresponde pas au format")
	private String email;

	@NotNull(message = "Password ne doit pas etre null")
	@Size(min=5)
	private String password;
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
