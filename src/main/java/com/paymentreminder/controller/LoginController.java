package com.paymentreminder.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.paymentreminder.model.User;

/**
 * 
 * @author lalit_bist
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginPage(){
		ModelAndView login = new ModelAndView();
		login.setViewName("/login/login.html");
		return login;
		
	}
	
	@RequestMapping(value="/process", method = RequestMethod.POST)
	public String processLogin(@RequestBody User user, BindingResult result, 
			HttpServletRequest request){
		if (result.hasErrors()) {
			System.out.println("Error fields"+ result.getFieldErrors());
			return "{ \"message\" :\"error\"}";
		}
		System.out.println(user.getUsername() + " "+user.getPassword());
		String returnMessage = "{ \"message\" :\"success\", \"username\":\""+user.getUsername()+"\"}";
		return returnMessage;
	}
	
	@RequestMapping(value="/registeration", method = RequestMethod.GET)
	public ModelAndView getRegisterPage(){
		ModelAndView register = new ModelAndView();
		register.setViewName("/login/register.html");
		return register;
		
	}
}
