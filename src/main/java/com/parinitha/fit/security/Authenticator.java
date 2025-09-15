package com.parinitha.fit.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.parinitha.fit.model.Person;
import com.parinitha.fit.model.Roles;
import com.parinitha.fit.repository.PersonRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Component
public class Authenticator implements AuthenticationProvider{
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	    String email = authentication.getName();
	    String rawPassword = authentication.getCredentials().toString();

	    Person person = personRepository.findByEmail(email);
	    if (person == null) {
	        throw new BadCredentialsException("Invalid credentials!");
	    }
	    
	    if (passwordEncoder.matches(rawPassword, person.getPwd())) {
	        System.out.println("DEBUG: Password matched!");
	        return new UsernamePasswordAuthenticationToken(
	                person.getEmail(),
	                null,
	                getGrantedAuthorities(person.getRoles())
	        );
	    } else {
	        throw new BadCredentialsException("Invalid credentials!");
	    }
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(String role) {
	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    grantedAuthorities.add(new SimpleGrantedAuthority(role)); 
	    return grantedAuthorities;
	}


}
