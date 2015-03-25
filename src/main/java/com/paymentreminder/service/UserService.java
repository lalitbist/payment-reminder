package com.paymentreminder.service;

import java.util.List;

import com.paymentreminder.model.User;
/**
 * 
 * @author lalit_bist
 *
 */
public interface UserService {
	public List<User> getAllUsers();
	
	public User getUserById(Integer userId);
	
	public User saveOrUpdate(User user);

}
