package com.fstg.gestionutilisateur.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class Utils {
	
	private final Random random=new SecureRandom() ;
	private final String STRINGALPHNUM="0123456789abcdefghijklmnopqrstvwxyzABCDEFGHIJKLMNOPQRSTVWXYZ";
	public String generateUserId(int lenght) {
		StringBuffer returnIdValue=new StringBuffer(lenght);
		for (int i=0;i<lenght;i++) {
			returnIdValue.append(STRINGALPHNUM.charAt(random.nextInt(STRINGALPHNUM.length())));
		}
		return new String(returnIdValue);
	}

}
