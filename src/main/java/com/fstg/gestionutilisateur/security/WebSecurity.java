package com.fstg.gestionutilisateur.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetaiService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder cryptPasswordEncoder) {
		this.bCryptPasswordEncoder = cryptPasswordEncoder;
		this.userDetaiService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
	    .cors().and()
	    .csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, SecurityConstant.SIGN_UP_URL)
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilter(getAuthenticationFilter())
		.addFilter(new AuthorizationFilter(authenticationManager()))
		.sessionManagement()
	    .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // utilise les sessions avec une corespondance avec token
	}

	protected AuthenticationFilter getAuthenticationFilter() throws Exception {
		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetaiService).passwordEncoder(bCryptPasswordEncoder);
//		super.configure(auth);
	}
}
