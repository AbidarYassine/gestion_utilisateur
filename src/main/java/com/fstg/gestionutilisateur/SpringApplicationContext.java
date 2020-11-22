package com.fstg.gestionutilisateur;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {

	
	public static ApplicationContext CONTEXT;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		CONTEXT=applicationContext;
	}
	
	public static Object getBean(String beanName) {
		return CONTEXT.getBean(beanName);
	}

}
