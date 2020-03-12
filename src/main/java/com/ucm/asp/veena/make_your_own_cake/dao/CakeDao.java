package com.ucm.asp.veena.make_your_own_cake.dao;

import java.util.List;

import com.ucm.asp.veena.make_your_own_cake.model.Cake;

public interface CakeDao {
	
	public void insertCake(Cake cake);

	List<Cake> getAllCakes();

}
