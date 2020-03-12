package com.ucm.asp.veena.make_your_own_cake.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ucm.asp.veena.make_your_own_cake.dao.UserDao;
import com.ucm.asp.veena.make_your_own_cake.model.User;



@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	/**
	 * Returns a list of all users
	 */
	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM user";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<User> result = new ArrayList<User>();
		for(Map<String, Object> row:rows){
			User user = new User();
			user.setUserId((String)row.get("userId"));
			user.setUsername((String)row.get("username"));
			result.add(user);
		}
		
		return result;
		
	}

	/**
	 * Returns a user object by ID
	 */
	@Override
	public User getUserById(String userId) {
		String sql = "SELECT * FROM users WHERE userId = ?";
		return (User)getJdbcTemplate().queryForObject(sql, new Object[]{userId}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUsername(rs.getString("username"));
				return user;
			}
		});
		
	}
	/**
	 * Returns a user object by Name
	 */
	@Override
	public User getUserByName(String userName) {
		String sql = "SELECT * FROM users WHERE Name = ?";
		return (User)getJdbcTemplate().queryForObject(sql, new Object[]{userName}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("uid"));
				user.setUsername(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				return user;
			}
		});
		
	}
	
	/**
	 * Get User object by email
	 */
	@Override
	public User getUserByEmail(String email) {
		String sql = "SELECT * FROM users WHERE Email = ?";
		return (User)getJdbcTemplate().queryForObject(sql, new Object[]{email}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("uid"));
				user.setUsername(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				return user;
			}
		});
		
	}

}
