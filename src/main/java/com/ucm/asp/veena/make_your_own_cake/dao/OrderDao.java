package com.ucm.asp.veena.make_your_own_cake.dao;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import com.ucm.asp.veena.make_your_own_cake.model.Cake;
import com.ucm.asp.veena.make_your_own_cake.model.Order;
import com.ucm.asp.veena.make_your_own_cake.model.User;

public interface OrderDao {
	public List<Cake> getAllCakes();
	public String getCakeID(String cakeName);
	public List<Order> getAllOrders();
	public void insertOrder(Order order);
	public void updateOrder(Order order);
	public List<Order> getNewOrders();
	public Blob getPhotoById(int id);
	public Order getOrderById(String id);
	public void deleteOrder(String id);
	public List<Order> getPopularCakes();
	public List<Order> getPopularUsers();
;}
