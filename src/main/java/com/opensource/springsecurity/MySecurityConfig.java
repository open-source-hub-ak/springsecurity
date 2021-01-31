package com.opensource.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//custom user details service and password encoder
		
/*		  InMemoryUserDetailsManager userDetailsService = new
		  InMemoryUserDetailsManager(); UserDetails user =
		  User.withUsername("tom").password(passwordEncoder.encode("pass")).authorities
		  ("read").build(); userDetailsService.createUser(user);
		  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);  //you can remove the passcode encoder as we have autowired Bcrypt encoder
		  
		  
		  
		  */
		 
		//Using Custom AuthorizationProvider
		auth.authenticationProvider(authenticationProvider);
		 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests()
		.antMatchers("/hello").authenticated() // hello will be authenticated
		.anyRequest().denyAll(); //this will make sure other than hello all the other request need to be denied
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
