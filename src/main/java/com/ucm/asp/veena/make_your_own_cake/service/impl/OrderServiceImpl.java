package com.ucm.asp.veena.make_your_own_cake.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucm.asp.veena.make_your_own_cake.dao.OrderDao;
import com.ucm.asp.veena.make_your_own_cake.model.Cake;
import com.ucm.asp.veena.make_your_own_cake.model.Order;
import com.ucm.asp.veena.make_your_own_cake.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;

	@Override
	public List<Cake> getAllCakes() {
		
		return orderDao.getAllCakes();
	}

	@Override
	public String getCakeID(String cakeName) {
		
		return orderDao.getCakeID(cakeName);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	@Override
	public void insertOrder(Order order) {
		orderDao.insertOrder(order);
		
	}
	
	public Order getOrderById(String id) {
		return orderDao.getOrderById(id);
	}
	
	public void updateOrder(Order order) {
		 orderDao.updateOrder(order);
	}
	@Override
	public void deleteOrder(String productId) {
		orderDao.deleteOrder(productId);
		
	}

	@Override
	public List<Order> getPopularCakes() {
		
		return orderDao.getPopularCakes();
	}

	@Override
	public List<Order> getPopularCustomers() {
		
		return orderDao.getPopularUsers();
	}
}
