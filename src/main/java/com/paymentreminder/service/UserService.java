package com.paymentreminder.service;

import java.util.List;

import com.paymentreminder.model.UserModel;
/**
 * 
 * @author lalit_bist
 *
 */
public interface UserService {
	public List<UserModel> getAllUsers();
	
	public UserModel getUserById(Integer userId);
	
	public UserModel saveOrUpdate(UserModel user);
	
	public UserModel getUserByEmail(String email);

}
