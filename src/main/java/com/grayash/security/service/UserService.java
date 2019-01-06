package com.grayash.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.grayash.security.entity.AuthEntity;
import com.grayash.security.model.CustomUserDetails;
import com.grayash.security.repository.UserRepository;

@Component
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthEntity entity = repository.findByCustomerId(username);
		if (entity == null || entity.getCustomerId() == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		} else {
			return new CustomUserDetails(entity.getCustomerId(), entity.getPassword());
		}
	}

}
