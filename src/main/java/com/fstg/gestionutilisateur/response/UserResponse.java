package com.fstg.gestionutilisateur.response;

import java.util.List;

public class UserResponse {

	private String fistName;
	private String lastName;
	private String email;
	private String userId;
	private List<AdresseResponse> adresses;


	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<AdresseResponse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<AdresseResponse> adresses) {
		this.adresses = adresses;
	}
}
