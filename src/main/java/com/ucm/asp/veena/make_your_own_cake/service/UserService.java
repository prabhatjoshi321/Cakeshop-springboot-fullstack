package com.ucm.asp.veena.make_your_own_cake.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucm.asp.veena.make_your_own_cake.model.User;


@Service
public interface UserService {
	List<User> getAllUsers();
	User getUserById(String userId);
	User getUserByEmail(String email);
}
