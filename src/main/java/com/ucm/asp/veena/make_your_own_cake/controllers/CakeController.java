package com.ucm.asp.veena.make_your_own_cake.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ucm.asp.veena.make_your_own_cake.model.Cake;
import com.ucm.asp.veena.make_your_own_cake.model.Order;
import com.ucm.asp.veena.make_your_own_cake.service.CakeService;
import com.ucm.asp.veena.make_your_own_cake.service.OrderService;

@Controller
public class CakeController {

	@Autowired
	CakeService cakeService;
	
	
	Cake cake;
	
	@RequestMapping(value="addCake",method=RequestMethod.POST)
	@ResponseBody
	public void insertCake(HttpServletRequest request,@RequestParam String cakeName,@RequestParam int stock,@RequestParam String type, @RequestParam double amount,
			@RequestParam("photo") MultipartFile photo) throws IOException {
		
		
		InputStream imageStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        if (photo != null) {
            // obtains input stream of the upload file
            imageStream = photo.getInputStream();
        }
         
		
		
		cake = new Cake();
		cake.setCakeName(cakeName);
		cake.setStock(stock);
		cake.setType(type);
		cake.setAmount(amount);
		cake.setImageStream(imageStream);
		cakeService.insertCake(cake);
	}
	

}
