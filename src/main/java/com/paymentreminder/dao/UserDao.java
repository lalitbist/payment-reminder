package com.paymentreminder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.paymentreminder.model.User;

/**
 * 
 * @author lalit_bist
 *
 */
public interface UserDao extends JpaRepository<User, Long>{ //can use JpaRepository or PagingAndSortingRepository
	
	@Query("from User")// User classs name instead of table name
	//@Query(value = "Select * from users",  nativeQuery = true) native sql query
	public List<User> getAllUsers();
	
	public User findByuserId(Integer userId);

}
