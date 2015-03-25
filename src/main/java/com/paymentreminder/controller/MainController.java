package com.paymentreminder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author lalit_bist
 *
 */
@RestController
@RequestMapping("/") 
public class MainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(){
		return "Welcome to Payment Reminder Help you manager your payments";
	}

}
