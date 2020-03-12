package com.ucm.asp.veena.make_your_own_cake.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ucm.asp.veena.make_your_own_cake.service.RegistrationService;


@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	/**
	 * This is the default signup controller
	 * @return
	 */
	@RequestMapping(value="/signup", method= RequestMethod.GET )
	public ModelAndView signUp() {
		return new ModelAndView("signup");
	}
	
	/**
	 * This method is to handle the registration functionality and save to DB.
	 * @param emailId
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param phone
	 * @param address
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String firstname,@RequestParam String address, @RequestParam String role, @RequestParam String dob,@RequestParam String emailId,@RequestParam String password,@RequestParam String phone, ModelMap model) throws ParseException {
		Date date_dob=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
		if(!registrationService.registerUser(firstname, address,role,date_dob,emailId,password,phone)) {
			model.put("errorMessage", "Registration Unsuccessful");
			return "login";
		}
		return "login";
	}
}
