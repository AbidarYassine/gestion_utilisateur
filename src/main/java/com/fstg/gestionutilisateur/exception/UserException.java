package com.fstg.gestionutilisateur.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = -3212198807566477661L;

	public UserException(String mesg) {
           super(mesg);
	}
}
