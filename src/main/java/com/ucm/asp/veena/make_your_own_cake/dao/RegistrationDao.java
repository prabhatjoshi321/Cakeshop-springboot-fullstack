package com.ucm.asp.veena.make_your_own_cake.dao;

import java.util.Date;

public interface RegistrationDao {


	boolean registerUser(String name, String address, String role, Date dob, String email, String password,
			String phone);

}
