package com.contactura.contactura.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.contactura.contactura.service.CustomUserDatailService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private CustomUserDatailService customUserDatailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeRequests() .anyRequest() .authenticated() .and() .httpBasic()
		 * .and().csrf().disable();
		 */
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	//autenticacao em memoria
	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception { auth.inMemoryAuthentication()
	 * .withUser("jessica").password("{noop}root").roles("USER") .and()
	 * .withUser("faustao").password("{noop}root").roles("USER", "ADMIN"); }
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDatailService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
