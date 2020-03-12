package com.ucm.asp.veena.make_your_own_cake.service;


public interface LoginService {

	public String validateCredentials(String email, String password);

	public String getUserId(String email);
}
