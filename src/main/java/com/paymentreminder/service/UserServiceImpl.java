package com.paymentreminder.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.paymentreminder.dao.UserDao;
import com.paymentreminder.model.UserModel;

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
	public List<UserModel> getAllUsers() {
		return (List<UserModel>) userDao.getAllUsers();
	}

	@Transactional(readOnly = true)
	@Override
	public UserModel getUserById(Integer userId) {
		return userDao.findByuserId(userId);
	}

	@Override
	@Transactional(readOnly = false)
	public UserModel saveOrUpdate(UserModel userModel) {
		UserModel userAfterSave = userDao.saveAndFlush(userModel);
		//userDao.save(userModel);
		return userAfterSave;
	}

	@Transactional(readOnly = true)
	@Override
	public UserModel getUserByEmail(String email) {
		UserModel userModel = userDao.findByemail(email);
		if(userModel == null){
			return (UserModel)new Object();
		}
		return userModel;
	}

}
