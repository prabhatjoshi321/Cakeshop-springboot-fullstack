 package com.ucm.asp.veena.make_your_own_cake.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ucm.asp.veena.make_your_own_cake.dao.RegistrationDao;
import com.ucm.asp.veena.make_your_own_cake.dao.UserDao;
import com.ucm.asp.veena.make_your_own_cake.model.User;



@Repository
public class RegistrationDaoImpl extends JdbcDaoSupport implements RegistrationDao {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserDao userDao;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
		setJdbcTemplate(jdbcTemplate);
	}
	
	/**
	 * This method helps in inserting the details to the database to register the user
	 */
	@Override
	public boolean registerUser(String name, String address, String role, Date dob,
			String email,String password,String phone) {
	
		long tel = 0;
		try {
		 tel = Long.parseLong(phone);
		}
		catch(NumberFormatException n) {
			//output error page			
		}
		return insertUserDetailsToDb(name, address,role,dob,email,password,tel);
	}

	
	/**1.same email id don’t allow
	2. Empty fields don’t save to db - server side validations
	3. Popup successful registration and error in registration messages
	*/

	private boolean insertUserDetailsToDb(String name,String address,String role,Date dob,String email,String password,long phone) {
		java.sql.Date sqlDate = new java.sql.Date(dob.getTime());
		//validate if email is already registered
		if(validateDuplicateEmail(email) == false) {
			if(validateOtherFields(password, name,role, phone , email, address) == true) {
				//get number of users, in order to insert the correct userID
				String getUserCountSql = "select * from Users";
				List<Map<String,Object>> number_of_users= jdbcTemplate.queryForList(getUserCountSql);
				
				//userId will be 1 more than the count of users in the system
				int userId = number_of_users.size()+1;
				//update the User table with the new user details
				int insertUser = jdbcTemplate.update("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?)",userId,name,address,role,sqlDate,email,password,phone);
				if(insertUser >= 1) {
					return true;
				}
		}			
		}
		
		return false;
		
	}
	
	/**
	 * Validate and returns a boolean by validating the other fields
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param phone
	 * @param address
	 * @return
	 */

	private boolean validateOtherFields(String password, String name, String role, long phone,String email, String address) {
		
		if ((null == password) || (password.isEmpty()) || (null == name) || (name.isEmpty())
				|| (null == role) || (role.isEmpty()) || (phone <= 0)
				|| (null == address) || (address.isEmpty()) || (null == role) || (role.isEmpty()) || (null == email) || (email.isEmpty())) {
			return false;
		}
		return true;
	}

	private boolean validateDuplicateEmail(String emailId) {
		User user = new User();
		try {
		if((null != emailId) && !emailId.isEmpty()) {
			try {
			 user = userDao.getUserByEmail(emailId);
			}
			catch(EmptyResultDataAccessException e) {//do nothing
				}
			
			if(user.getUsername().equals(emailId)) {
				return true;
			}
		}
		}
		catch(Exception e) {
		}
		return false;
	}

}
