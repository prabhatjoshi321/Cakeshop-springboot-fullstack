package com.ucm.asp.veena.make_your_own_cake.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ucm.asp.veena.make_your_own_cake.dao.OrderDao;
import com.ucm.asp.veena.make_your_own_cake.model.Cake;
import com.ucm.asp.veena.make_your_own_cake.model.Order;
import com.ucm.asp.veena.make_your_own_cake.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDao orderDao;
	
	Order order;
	private String deleteId;
	
	
	@RequestMapping(value = "/getCakePhoto/{id}", method=RequestMethod.GET)
	public void getCakePhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		Blob ph = orderDao.getPhotoById(id);
		
		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	@RequestMapping(value="addProduct",method=RequestMethod.POST)
	@ResponseBody
	public void insertCake(HttpServletRequest request,@RequestParam String username,@RequestParam String cakeName,@RequestParam int quantity, @RequestParam String shipping_address, @RequestParam String message,
			@RequestParam float amount) {
		String userId = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("userCookie")) {
					userId = c.getValue();					
				}
				
			}
		}
		order = new Order();
		order.setUsername(username);
		order.setCakeName(cakeName);
		order.setQty(quantity);
		order.setShippingAddress(shipping_address);
		order.setUserId("1");
		order.setMessage(message);
		order.setAmount(amount);
		order.setOrder_status("NEW");
		orderService.insertOrder(order);
		
	}
	
	/**
	 * This method is also a GET Request from the dashboard to load sales, channels, trending products and profit calculator.
	 * @param request
	 * @param inventory
	 * @param model
	 * @return
	 */
	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public String productsData(HttpServletRequest request,@ModelAttribute("products") Order order,ModelMap model) {
		List<Order> orders = orderService.getAllOrders();
		List<Cake> cakeList = orderService.getAllCakes();
		List<Order> popularUsers = orderService.getPopularCustomers();
		List<Order> popularCakes = orderService.getPopularCakes();
		model.addAttribute("cakes",cakeList);
		model.addAttribute("orders", orders);
		model.addAttribute("popularUsers",popularUsers);
		model.addAttribute("popularCakes", popularCakes);
		
		
		return "order";
		
	}
	
	//Prepopulating details of product to edit
		@RequestMapping(value="/editInventory", method=  RequestMethod.GET)
		public ModelAndView editInventory(@RequestParam("id") String id) {
			//List<Order> ordersList = new ArrayList<Order>();
			Order myOrder = orderService.getOrderById(id);
			//ordersList.add(myOrder);
			ModelAndView model = new ModelAndView("edit_order");
			model.addObject("order",myOrder);
			List<Cake> cakeList = orderService.getAllCakes();
			model.addObject("cakes",cakeList);
			return model;
		}
		
		//Updating a product in database
		@RequestMapping(value = "/editInventory", method = RequestMethod.POST)
		public String editInventory(HttpServletRequest request,@RequestParam String id, @RequestParam String username,@RequestParam String cakeName,@RequestParam int quantity, @RequestParam String shipping_address, @RequestParam String message,
				@RequestParam float amount) {
			Order order = new Order();
			order.setUsername(username);
			order.setCakeName(cakeName);
			order.setQty(quantity);
			order.setShippingAddress(shipping_address);
			order.setMessage(message);
			order.setAmount(amount);
			order.setOrderId(id);
			order.setOrder_status("NEW");
			orderService.updateOrder(order);
			return "redirect:/order";
		}
		
		//View for delete product
		@RequestMapping("/deleteOrder")
		public ModelAndView deleteOrder(@RequestParam("id") String id) {
			deleteId = id;
			ModelAndView model = new ModelAndView("delete_order");
			return model;
		}
		
		//Deleting a product in database
		@RequestMapping(value="/deleteOrder", method = RequestMethod.POST)
		public String deleteOrder() {
			orderService.deleteOrder(deleteId);
			return "redirect:/order";
		}

}
