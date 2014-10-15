package org.slevin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slevin.common.Item;
import org.slevin.common.Order;
import org.slevin.dao.ItemsDao;
import org.slevin.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrdersDao orderService;
	
	@Autowired
	ItemsDao itemService;
	
	
	 @RequestMapping(value="/all", method = RequestMethod.GET)
	 public ModelAndView getAllOrdersView() throws Exception
	 {
		 
	  ModelAndView mav = new ModelAndView("/orders/showAllOrders");
	  List<Order> orders = orderService.findAll();
	  mav.addObject("orders", orders);
	  return mav;
	 }
	 
	 @RequestMapping(value="/new", method=RequestMethod.GET)
	 public ModelAndView newOrderForm() throws Exception
	 {
	  ModelAndView mav = new ModelAndView("/orders/newOrder");
	  Order order = new Order();
	  List<Item> items = itemService.findAll();
	  
	  mav.getModelMap().put("newOrder", order);
	  mav.getModelMap().put("items", items);
	  return mav;
	 }
	 
	 @RequestMapping(value="/saveOrder", method=RequestMethod.POST)
	 public String create(@ModelAttribute("newOrder")Order order,@RequestParam(required = false) List<Long> itemId , BindingResult result, SessionStatus status) throws Exception
	 {
		 if(itemId != null){
	     for(Long idItem : itemId){
	    	 System.out.println("############ "+idItem);
	    	 Item item = itemService.findById(idItem);
	    	 order.getItems().add(item);
	     }
		 }
	  
      order.setOrderDate(new Date());
	  orderService.merge(order);
	  status.setComplete();
	  return "redirect:/orders/all.html";
	 }
	 
	
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView edit(@PathVariable Long id) throws Exception 
	 {
	  ModelAndView mav = new ModelAndView("/orders/editOrder");
	  Order order = orderService.findById(id);
	  List<Item> items = new ArrayList<Item>(order.getItems());
	  mav.addObject("editOrder", order);
	  mav.addObject("items", items);
	  return mav;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	 public String update(@PathVariable Long id, @ModelAttribute("editOrder") Order order, BindingResult result, SessionStatus status) throws Exception
	 {
	  Order orderTmp = orderService.findById(id);
	  order.setOrderDate(orderTmp.getOrderDate());
	  order.setItems(orderTmp.getItems());
	  orderService.merge(order);
	  status.setComplete();
	  return "redirect:/orders/all.html";
	 }
	 
	 /*
	  * REST SERVICES
	  */
	
	 @RequestMapping(value="/all", method = RequestMethod.GET, produces={"application/json", "application/xml"} )
	 public @ResponseBody
	 List<Order> getOrders() throws Exception{
			return orderService.findAll();
	 }
	 
	 @RequestMapping(value="/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public @ResponseBody Order getOrder(@PathVariable Long id) throws Exception {
	 
			return orderService.findById(id);
	 
	 }
	 
	 @RequestMapping(value="/delete/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public ModelAndView delete(@PathVariable Long id) throws Exception
	 {
	  ModelAndView mav = new ModelAndView("redirect:/orders/all.html");
	  orderService.remove(id);
	  return mav;
	 } 

	 
	
	
}
