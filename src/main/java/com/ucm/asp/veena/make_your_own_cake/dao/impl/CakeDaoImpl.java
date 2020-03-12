package com.ucm.asp.veena.make_your_own_cake.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ucm.asp.veena.make_your_own_cake.dao.CakeDao;
import com.ucm.asp.veena.make_your_own_cake.model.Cake;

@Repository
public class CakeDaoImpl extends JdbcDaoSupport implements CakeDao{
	
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
			cakes.setAmount((double)row.get("AMOUNT"));
			cakes.setType((String) row.get("TYPE"));
			cakeList.add(cakes);
		}
		return cakeList;
	}
    
    public void insertCake(Cake cake) {

		try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
			String insertCake = "INSERT INTO cake values (?,?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insertCake);
			String getCakeCountSql = "select * from Cake";
			List<Map<String,Object>> number_of_orders= getJdbcTemplate().queryForList(getCakeCountSql);
			
			//orderId will be 1 more than the count of orders in the system
			int cakeId = number_of_orders.size()+1;
			//int userId = 
			statement.setInt(1, cakeId);
			
			InputStream imageStream = cake.getImageStream();
			if (imageStream != null) {
				// fetches input stream of the upload file for the blob column
				statement.setBlob(2, imageStream);
			}
			
			statement.setString(3, cake.getCakeName());
			statement.setInt(4,cake.getStock());
			statement.setDouble(5,cake.getAmount());
			statement.setString(6, cake.getType());
			statement.executeUpdate();
		}catch (SQLException ex) {
            ex.printStackTrace();
        }  
	}
    
    

}
