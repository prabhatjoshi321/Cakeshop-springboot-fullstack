package com.ucm.asp.veena.make_your_own_cake.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ucm.asp.veena.make_your_own_cake.dao.LoginDao;
import com.ucm.asp.veena.make_your_own_cake.model.User;





@Repository
public class LoginDaoImpl  extends JdbcDaoSupport implements LoginDao {
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	/**
	 * This method makes a call to the internal validatePassword method
	 */
	@Override
	public String validateCredentials(String email, String password) {
		return validatePassword(email,password);
		
	}
	/**
	 * This method validates if the password entered matches the user's password in the database
	 */
	@Override
	public String validatePassword(String email,String password) {
		String sql = "SELECT * FROM users WHERE email = ?";
		User currentUser = new User();
		try {
		currentUser = (User)getJdbcTemplate().queryForObject(sql, new Object[] {email},new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("uid"));
				user.setUsername(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				return user;
			}
		});
		}
		catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return "false";
		}
		if(currentUser.getPassword().equals(password))
		{
			if(currentUser.getRole().equalsIgnoreCase("user"))
			return "user";
			else if(currentUser.getRole().equalsIgnoreCase("admin"))
				return "admin";
		}
		
		return "invalid";
		
	}
	/**
	 * This method returns the userID for the specified email
	 */
	@Override
	public String getUserID(String email) {
		String sql = "SELECT userId FROM users WHERE name = ?";
		User currentUser = (User)getJdbcTemplate().queryForObject(sql, new Object[] {email},new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("uid"));
				return user;
			}
		});
		return currentUser.getUserId();
	}

}
