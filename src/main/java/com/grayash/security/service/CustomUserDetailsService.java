package com.grayash.security.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CustomUserDetailsService implements AuthenticationProvider {

	@Autowired
	private UserService service;
	
	public CustomUserDetailsService() {
		System.out.println("*******Inside CustomUserDetailsService******");
		System.out.println("UserService--->"+service);
	}

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		if (authentication.getName() == null || authentication.getCredentials() == null) {
			return null;
		}

		final String customerId = authentication.getName();
		final Object password = authentication.getCredentials();

		if (StringUtils.isEmpty(customerId) || StringUtils.isEmpty(password)) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		UserDetails customerDetails = service.loadUserByUsername(customerId);

		if (customerDetails == null || StringUtils.isEmpty(customerDetails.getUsername())) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		if (customerId.equalsIgnoreCase(customerDetails.getUsername()) && password.equals(customerDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(customerId, password, getAuthority());
		} else {

			throw new UsernameNotFoundException("Invalid username or password.");
		}
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Collections.emptyList();
	}

}
