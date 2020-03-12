package com.ucm.asp.veena.make_your_own_cake.dao.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ucm.asp.veena.make_your_own_cake.dao.OrderDao;
import com.ucm.asp.veena.make_your_own_cake.model.Cake;
import com.ucm.asp.veena.make_your_own_cake.model.Order;
import com.ucm.asp.veena.make_your_own_cake.model.User;

@Repository
public class OrderDaoImpl extends JdbcDaoSupport implements OrderDao {
	@Autowired
	DataSource dataSource;
	
	@Value("${spring.datasource.url}")
	String databaseURL;
    String user = "root";
    String password = "joshi";
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public List<Cake> getAllCakes() {
		String getCakesQuery = "SELECT * FROM Cake";
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(getCakesQuery);
		List<Cake> cakeList = new ArrayList<Cake>();
		
		for(Map<String, Object> row:rows) {
			Cake cakes = new Cake();
			cakes.setCakeId((String)row.get("CID"));
			cakes.setCakeName((String)row.get("CAKENAME"));
			cakes.setStock((int)row.get("STOCK"));
			cakes.setAmount((float)row.get("AMOUNT"));
			cakes.setType((String) row.get("TYPE"));
			cakeList.add(cakes);
		}
		return cakeList;
	}
	
	@Override
	public List<Order> getAllOrders() {
		String getCakesQuery = "SELECT * FROM Orders";
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(getCakesQuery);
		List<Order> orderList = new ArrayList<Order>();
		
		for(Map<String, Object> row:rows) {
			Order orders = new Order();
			orders.setOrderId((String)row.get("OID"));
			orders.setCakeId((String)row.get("CID"));
			orders.setCakeName((String)row.get("CNAME"));
			orders.setQty((int)row.get("QTY"));
			orders.setUsername((String)row.get("USERNAME"));
			orders.setShippingAddress((String) row.get("S_ADDRESS"));
			orders.setMessage((String) row.get("MSG"));
			orders.setOrder_status((String)row.get("ORDER_STATUS"));
			orders.setAmount((float)row.get("amount"));
			orders.setUserId((String)row.get("UID"));
			orderList.add(orders);
			
		}
		
		return orderList;
	}
	
	/**
	 * Returns a user object by ID
	 */
	@Override
	public Order getOrderById(String id) {
		String getCakesQuery = "SELECT * FROM Orders WHERE oid = "+id;
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(getCakesQuery);
		Order order = new Order();
		
		for(Map<String, Object> row:rows) {
				order.setOrderId(id);
				order.setCakeName((String)row.get("CNAME"));
				order.setQty((int)row.get("QTY"));
				order.setUsername((String)row.get("username"));
				order.setShippingAddress((String)row.get("s_address"));
				order.setMessage((String)row.get("msg"));
				order.setUserId((String)row.get("uid"));
				order.setCakeId((String)row.get("cid"));
				order.setAmount((float)row.get("amount"));
				
			}
		return order;
		
	}
	
	@Override
	public List<Order> getNewOrders() {
		String getCakesQuery = "SELECT * FROM Orders where ORDER_STATUS = \'NEW\'";
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(getCakesQuery);
		List<Order> orderList = new ArrayList<Order>();
		
		for(Map<String, Object> row:rows) {
			Order orders = new Order();
			orders.setCakeId((String)row.get("CID"));
			orders.setCakeName((String)row.get("CNAME"));
			orders.setQty((int)row.get("QTY"));
			orders.setUsername((String)row.get("USERNAME"));
			orders.setShippingAddress((String) row.get("S_ADDRESS"));
			orders.setMessage((String) row.get("MSG"));
			orders.setOrder_status((String)row.get("ORDER_STATUS"));
			orderList.add(orders);
			
		}
		
		return orderList;
	}

	

	@Override
	public String getCakeID(String cakeName) {
		String getCakesIdQuery = "SELECT * FROM Cake where cakename="+cakeName;
		
		return getJdbcTemplate().queryForObject(
				getCakesIdQuery, new Object[]{cakeName}, String.class);
	}
	
	public void insertOrder(Order order) {

		try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
			String insertInventory = "INSERT INTO orders values (?,?, ?, ?, ?, ?, ?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertInventory);
			String getOrderCountSql = "select * from Orders";
			List<Map<String,Object>> number_of_orders= getJdbcTemplate().queryForList(getOrderCountSql);
			
			//orderId will be 1 more than the count of orders in the system
			int orderId = number_of_orders.size()+1;
			statement.setInt(1, orderId);
			statement.setString(2,order.getCakeName());
			statement.setInt(3, order.getQty());
			statement.setString(4,order.getUsername());
			statement.setString(5,order.getShippingAddress());
			statement.setString(6, order.getMessage());
			System.out.println("userID is"+order.getUserId());
			statement.setString(7, order.getUserId());
			statement.setString(8, order.getCakeId());
			statement.setFloat(9, order.getAmount());
			statement.setString(10, order.getOrder_status());
			statement.executeUpdate();
		}catch (SQLException ex) {
            ex.printStackTrace();
        }  
	}
	
	@Override
	public void updateOrder(Order order) {
		try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
			String updateInventory = "update orders " +
					"set cname = ?, qty = ?, username = ?, s_address = ?, msg =?, amount = ? where OID = "+order.getOrderId();
			PreparedStatement statement = connection.prepareStatement(updateInventory);
            statement.setString(1, order.getCakeName());
            statement.setInt(2, order.getQty());
            statement.setString(3, order.getUsername());
            statement.setString(4, order.getShippingAddress());
            statement.setString(5, order.getMessage());
            statement.setFloat(6, order.getAmount());
            statement.executeUpdate();
		}catch (SQLException ex) {
            ex.printStackTrace();
        }  
	}

	@Override
	public Blob getPhotoById(int id) {
		String query = "select image from cake where cid=?";

		Blob photo = getJdbcTemplate().queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}
	
	@Override
	public void deleteOrder(String id) {
		String deleteProduct = "delete from Orders where oid = ?";
		getJdbcTemplate().update(deleteProduct, new Object[]{
				id
		});
		
	}
	
	@Override
	public List<Order> getPopularCakes() {
		String popularCakes = "SELECT cname, cid, count(cid) as orderedQty \n" + 
				"FROM Orders GROUP BY cid,cname order by orderedQty desc"  ;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(popularCakes);
		List<Order> orderList = new ArrayList<Order>();
		
		for(Map<String, Object> row:rows) {
			Order order = new Order();
			order.setCakeId((String)row.get("cid"));
			order.setCakeName((String)row.get("cname"));
			orderList.add(order);
		}
		return orderList;
	}
	
	@Override
	public List<Order> getPopularUsers() {
		String popularUsers = "select username, count(username) from orders\n" + 
				"group by username\n" + 
				"having count(username) > 1\n" + 
				"order by username;";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(popularUsers);
		List<Order> orderList = new ArrayList<Order>();
		Order order = new Order();
		for(Map<String, Object> row:rows) {
			order.setCakeId((String)row.get("cid"));
			order.setCakeName((String)row.get("cname"));
			order.setUsername((String)row.get("username"));
			orderList.add(order);
		}
		return orderList;
	}
}
