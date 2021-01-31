package com.opensource.springsecurity;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		// here is actual authentication logic and we dont use User detail service
		String uname = authentication.getName();
		String pass = authentication.getCredentials().toString();

		if ("tom".equals(uname) && "pass".equals(pass)) {
			return new UsernamePasswordAuthenticationToken(uname, pass, Collections.emptyList());
		} else {
			throw new BadCredentialsException("Invalid username or password");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {

		// used to check which all kind of authentication is supported
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
