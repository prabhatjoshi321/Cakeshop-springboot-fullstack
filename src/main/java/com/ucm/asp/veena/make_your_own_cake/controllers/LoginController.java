package com.ucm.asp.veena.make_your_own_cake.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ucm.asp.veena.make_your_own_cake.service.UserService;
import com.ucm.asp.veena.make_your_own_cake.service.impl.LoginServiceImpl;
import com.ucm.asp.veena.make_your_own_cake.util.CookieUtil;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	LoginServiceImpl service;
	
	/**
	 * This method handles the Get request 
	 * where it returns the login jsp when the url is redirected to login**/
	@RequestMapping(value="/login")
	public ModelAndView firstPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("login");
		
		return model;
	}
	
	
	
	/** This method handles the POST request, the credentials are 
	validated and the user on successful authentication is redirected to dashboard. **/
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String email,@RequestParam String pwd,HttpServletResponse response) {
		
		//validate the credentials and display error message if the user credentials are wrong	
		if(service.validateCredentials(email, pwd).contains("invalid")) {
			String errorMsg = "Invalid Credentials";
			return "login";
		}
		else if(service.validateCredentials(email, pwd).contains("user"))
		{
			CookieUtil userCookie = new CookieUtil("userId",userService.getUserByEmail(email).getUserId());
			CookieUtil usernameCookie = new CookieUtil("username",userService.getUserByEmail(email).getUserId());
			response.addCookie(userCookie);
			response.addCookie(usernameCookie);
			return "dashboard";
		}
		else if(service.validateCredentials(email, pwd).contains("admin")) {
			CookieUtil userCookie = new CookieUtil("userId",userService.getUserByEmail(email).getUserId());
			CookieUtil usernameCookie = new CookieUtil("username",userService.getUserByEmail(email).getUserId());
			response.addCookie(userCookie);
			response.addCookie(usernameCookie);
			return "admin-dashboard";
		}
		
		CookieUtil userCookie = new CookieUtil("userId",userService.getUserByEmail(email).getUserId());
		CookieUtil usernameCookie = new CookieUtil("username",userService.getUserByEmail(email).getUserId());
		response.addCookie(userCookie);
		response.addCookie(usernameCookie);
		
		return "login";
	}
	
}
