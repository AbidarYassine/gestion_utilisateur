package com.fstg.gestionutilisateur.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 5259865374672317991L;
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false, length = 50)
	private String fistName;

	@Column(nullable = false, length = 60, unique = true)
	private String userId;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 120, unique = true)
	private String email;

	@Column(nullable = false)
	private String encryptedPassword;

	@Column(nullable = true)
	private String emailVerification;

	@Column(name = "emailVerficationStatus")
	private Boolean emailVerficationStatus = false;
// CascadeType.ALL l'hor de la creation d'une user ==> creation de ces addresse, and remove user==> remove all addresse
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<AdresseEntity> adresses;

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

	public Boolean getEmailVerficationStatus() {
		return emailVerficationStatus;
	}

	public void setEmailVerficationStatus(Boolean emailVerficationStatus) {
		this.emailVerficationStatus = emailVerficationStatus;
	}

	public List<AdresseEntity> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<AdresseEntity> adresses) {
		this.adresses = adresses;
	}
}
