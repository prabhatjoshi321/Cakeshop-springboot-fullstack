package com.ucm.asp.veena.make_your_own_cake.dao;

import java.util.List;

import com.ucm.asp.veena.make_your_own_cake.model.User;


public interface UserDao {
	
	List<User> getAllUsers();
	User getUserById(String userId);
	User getUserByEmail(String email);
	User getUserByName(String userName);

}
