package com.paymentreminder.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paymentreminder.model.UserModel;
import com.paymentreminder.service.UserService;

/**
 * 
 * @author lalit_bist
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<UserModel> getUsers(){
		return userService.getAllUsers();
	}
	
	//@PreAuthorize("hasAuthority('ADMIN') or hasRole('USER')")
	@RequestMapping(value="/{id}", method = RequestMethod.GET )
	public UserModel getUserById(@PathVariable("id") Integer userId){
		return userService.getUserById(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(@RequestBody UserModel userModel, BindingResult result, 
			HttpServletRequest request){
		if (result.hasErrors()) {
			System.out.println("Error fields"+ result.getFieldErrors());
			return "{ \"message\" :\"error\"}";
		}
		userModel.setCreatedBy("System");
		userModel.setCreatedOn(new Date());
		userModel.setUserType("public");
		userModel.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
		userService.saveOrUpdate(userModel);
		System.out.println(userModel.getUsername() + " "+userModel.getPassword());
		String returnMessage = "{ \"message\" :\"success\", \"username\":\""+userModel.getUsername()+"\"}";
		return returnMessage;
	}
}

