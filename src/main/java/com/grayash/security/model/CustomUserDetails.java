package com.grayash.security.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;


@Data
public class CustomUserDetails implements UserDetails{
	
	private String username;
    private String password;
    
    public CustomUserDetails(String username, String password) {
    	this.username = username;
    	this.password = password;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
