package com.paymentreminder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.paymentreminder.model.UserModel;

/**
 * 
 * @author lalit_bist
 *
 */
public interface UserDao extends JpaRepository<UserModel, Long>{ //can use JpaRepository or PagingAndSortingRepository
	
	@Query("from UserModel")// User classs name instead of table name
	//@Query(value = "Select * from users",  nativeQuery = true) native sql query
	public List<UserModel> getAllUsers();
	public UserModel findByuserId(Integer userId);
	public UserModel findByemail(String email);

}
