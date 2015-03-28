package com.paymentreminder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paymentreminder.model.UserModel;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired 
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		UserModel userModel = userService.getUserByEmail(email);
		if(userModel == null){
			new UsernameNotFoundException(String.format("User with email=%s was not found", email));
		}
		return new User(userModel.getEmail(),userModel.getPassword(), AuthorityUtils.createAuthorityList(userModel.getUserType()));
	}

}
