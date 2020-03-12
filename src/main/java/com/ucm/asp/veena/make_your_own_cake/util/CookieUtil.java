package com.ucm.asp.veena.make_your_own_cake.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil extends Cookie{

	public CookieUtil(String name, String value) {
		super(name, value);
		setMaxAge(60*60*24*365);
		//to delete a cookie setMaxAge(0);
	}
	public static String getCookieValue(String name, String defaultValue, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals(name)) {
					return cookie.getValue();
				}
				
			}
		}
		return defaultValue;
	}
}
