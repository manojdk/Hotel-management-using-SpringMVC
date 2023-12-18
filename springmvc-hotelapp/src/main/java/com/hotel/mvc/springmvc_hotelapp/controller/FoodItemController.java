package com.hotel.mvc.springmvc_hotelapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.mvc.springmvc_hotelapp.dao.FoodProductDaoImpl;
import com.hotel.mvc.springmvc_hotelapp.dto.Customer;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodItem;
import com.hotel.mvc.springmvc_hotelapp.dto.FoodProduct;
import com.hotel.mvc.springmvc_hotelapp.util.BillService;

@Controller
public class FoodItemController {
	static int count  = 0;
	
	@Autowired
	FoodProductDaoImpl productDao;
	
	@Autowired
	BillService service;
	
	@RequestMapping("addItem")
	public ModelAndView addItem(@RequestParam int id){
		
		FoodProduct product = productDao.getProduct(id);
		
		FoodItem item = new FoodItem();
		item.setItemName(product.getFoodName());
		item.setPrice(product.getCost());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("item" , item);
		mv.setViewName("quantity.jsp");
		return mv ;
		
	}
	
	
	@RequestMapping("toOrder")
	public ModelAndView toOrder(@ModelAttribute FoodItem item, HttpServletRequest req ){
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("allitems");
		
		double totalCost=service.calculate(item.getQuantity(), item.getPrice());
		item.setTotalCost(totalCost);
		
		if(obj == null) {
			ArrayList<FoodItem> items = new ArrayList<FoodItem>();
			items.add(item);
			session.setAttribute("allitems", items);
		}
		else {
			ArrayList<FoodItem> items = (ArrayList<FoodItem>) session.getAttribute("allitems");
			items.add(item);
			session.setAttribute("allitems", items);
		}
		System.out.println(item);
		
		ArrayList<FoodProduct> products = productDao.getAllProducts();
		ModelAndView mv = new ModelAndView();
		mv.addObject("allproducts" , products);
		mv.setViewName("displayfooditems.jsp");
		return mv ;
	}

	@RequestMapping("cart")
	public ModelAndView cart(HttpServletRequest req ) {
		
		HttpSession session = req.getSession();
		
		ArrayList<FoodItem> items = (ArrayList<FoodItem>) session.getAttribute("allitems");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("myitems" , items);
		mv.setViewName("cart.jsp");
		return mv ;
		
	}
	
	@RequestMapping("deleteItem")
	public ModelAndView deleteItem(@RequestParam int value , HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		ArrayList<FoodItem> items = (ArrayList<FoodItem>) session.getAttribute("allitems");
		items.remove(value);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("myitems" ,items);
		mv.setViewName("cart.jsp");
		return mv ;
		
	}
	
	@RequestMapping("next")
	public ModelAndView next(HttpServletRequest req ) {
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("customermodel" ,new Customer());
		mv.setViewName("customer.jsp");
		return mv ;
		
	}
	
	@RequestMapping("add")
	public void add(@RequestParam String food , HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession session = req.getSession();
		
		
		Object obj = session.getAttribute("fooditems");
		
		if(obj == null) {
			ArrayList al = new ArrayList();
			al.add(food);
			
			session.setAttribute("fooditems", al);
		}
		else {
			ArrayList al = (ArrayList) session.getAttribute("fooditems");
			al.add(food);
			session.setAttribute("fooditems", al);
		}
		out.println("<center><h3>"+food+" is added"+"</h3></center>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("displayfooditems.jsp");
		dispatcher.include(req, resp);
	}
}
