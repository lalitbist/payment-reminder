package com.paymentreminder.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.paymentreminder.dao.UserDao;
import com.paymentreminder.model.User;

/**
 * 
 * @author lalit_bist
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userDao.getAllUsers();
	}

	@Transactional(readOnly = true)
	@Override
	public User getUserById(Integer userId) {
		return userDao.findByuserId(userId);
	}

	@Override
	public User saveOrUpdate(User user) {
		User userAfterSave = userDao.saveAndFlush(user);
		//userDao.save(user);
		return userAfterSave;
	}

}
