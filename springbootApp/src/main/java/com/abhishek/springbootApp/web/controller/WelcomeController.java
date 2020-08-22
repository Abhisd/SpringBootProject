package com.abhishek.springbootApp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;



//@Controller picks up methods from the class as request mapping.

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	//@ResponseBody
	//@ResponseBody converts messages to jsp known as message converter.
	public String showloginPage(ModelMap model) {
		model.put("name", getLogggedinUserName());
		return "welcome";
	}
	
	private String getLogggedinUserName() {
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		}
		return principal.toString();
	}
	
	
	
}







