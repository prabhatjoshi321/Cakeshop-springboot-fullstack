package com.ucm.asp.veena.make_your_own_cake.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	
	@RequestMapping(value="/sign_out_action",method = RequestMethod.GET)
	public String handleLogout(HttpServletRequest request) {
		//get the userId cookie and clear it before logging out the user
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("userId")) {
					String userId = c.getValue();
					c.setMaxAge(0);
				}
			}
		}
		//redirect to login page
		return "redirect:login";
	}

}
