package com.fstg.gestionutilisateur.shared.dto;

import com.fstg.gestionutilisateur.shared.dto.AddressDto;

import java.io.Serializable;
import java.util.List;

// class for shared info betwene couche (presentation,service ,data layer)
public class UserDto implements Serializable {
	
	private static final long serialVersionUID = 8241230220595318136L;
	private long id;
	private String fistName;
	private String userId;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;
	private String emailVerification;
	private Boolean emailVerficationStatus=false;
	private List<AddressDto> adresses;


	public List<AddressDto> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<AddressDto> adresses) {
		this.adresses = adresses;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerification() {
		return emailVerification;
	}

	public void setEmailVerification(String emailVerification) {
		this.emailVerification = emailVerification;
	}

	public Boolean isEmailVerficationStatus() {
		return emailVerficationStatus;
	}

	public void setEmailVerficationStatus(Boolean emailVerficationStatus) {
		this.emailVerficationStatus = emailVerficationStatus;
	}

}
