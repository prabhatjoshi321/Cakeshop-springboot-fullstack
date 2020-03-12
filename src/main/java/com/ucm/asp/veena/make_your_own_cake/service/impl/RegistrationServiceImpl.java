package com.ucm.asp.veena.make_your_own_cake.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucm.asp.veena.make_your_own_cake.dao.RegistrationDao;
import com.ucm.asp.veena.make_your_own_cake.service.RegistrationService;


@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	RegistrationDao registrationDao;

	@Override
	public boolean registerUser(String name, String address, String role, Date dob,String email,String password,String phone)
			 {
		return registrationDao.registerUser(name, address,role,dob,email,password,phone);
	}
}
