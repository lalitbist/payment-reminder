package com.paymentreminder.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paymentreminder.model.User;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET )
	public User getUserById(@PathVariable("id") Integer userId){
		return userService.getUserById(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(@RequestBody User user, BindingResult result, 
			HttpServletRequest request){
		if (result.hasErrors()) {
			System.out.println("Error fields"+ result.getFieldErrors());
			return "{ \"message\" :\"error\"}";
		}
		user.setCreatedBy("System");
		user.setCreatedOn(new Date());
		user.setUserType("public");
		userService.saveOrUpdate(user);
		System.out.println(user.getUsername() + " "+user.getPassword());
		String returnMessage = "{ \"message\" :\"success\", \"username\":\""+user.getUsername()+"\"}";
		return returnMessage;
	}
	
}

