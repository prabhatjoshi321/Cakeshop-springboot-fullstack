package com.ucm.asp.veena.make_your_own_cake.service;

import java.util.Date;

public interface RegistrationService {


	boolean registerUser(String name, String address, String role, Date dob, String email, String password,
			String phone);
	

}
