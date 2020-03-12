package com.ucm.asp.veena.make_your_own_cake.service;

import java.util.List;

import com.ucm.asp.veena.make_your_own_cake.model.Cake;
import com.ucm.asp.veena.make_your_own_cake.model.Order;

public interface CakeService {

	public void insertCake(Cake cake);
	public List<Cake> getAllCakes();
}
