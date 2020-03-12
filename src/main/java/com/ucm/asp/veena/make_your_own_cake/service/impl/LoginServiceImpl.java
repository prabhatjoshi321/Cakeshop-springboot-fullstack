package com.ucm.asp.veena.make_your_own_cake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucm.asp.veena.make_your_own_cake.dao.LoginDao;
import com.ucm.asp.veena.make_your_own_cake.service.LoginService;



@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDao loginDao;

	@Override
	public String validateCredentials(String email, String password) {
		return loginDao.validateCredentials(email, password);
	}

	@Override
	public String getUserId(String email) {
		if(null != loginDao.getUserID(email) && !loginDao.getUserID(email).isEmpty() ) {
			return loginDao.getUserID(email);
		}
		else {
		return "";
		}
	}
	

}
