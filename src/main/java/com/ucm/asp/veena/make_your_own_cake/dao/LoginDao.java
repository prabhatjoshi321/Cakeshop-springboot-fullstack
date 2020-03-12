package com.ucm.asp.veena.make_your_own_cake.dao;

public interface LoginDao {
	String validateCredentials(String email, String password);
	public String validatePassword(String email,String password);
	public String getUserID(String email);

}
