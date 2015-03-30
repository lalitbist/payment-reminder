package com.paymentreminder.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.paymentreminder.model.UserModel;
import com.paymentreminder.service.UserService;

/**
 * 
 * @author lalit_bist
 *
 */
@RestController
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(){
		ModelAndView login = new ModelAndView("/login/login.html");
		return login;
		
	}
	
	@RequestMapping(value="/process", method = RequestMethod.POST)
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
	
	@RequestMapping(value="/registeration", method = RequestMethod.GET)
	public ModelAndView getRegisterPage(){
		ModelAndView register = new ModelAndView();
		register.setViewName("/login/register.html");
		return register;
		
	}
	
	
}
