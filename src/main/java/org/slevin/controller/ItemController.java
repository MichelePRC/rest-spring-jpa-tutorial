package org.slevin.controller;

import java.util.List;

import org.slevin.common.Item;
import org.slevin.dao.ItemsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemsDao itemService;
	
	 @RequestMapping(value="/all", method = RequestMethod.GET)
	 public ModelAndView getAllItemsView() throws Exception
	 {
		 
	  ModelAndView mav = new ModelAndView("/items/showAllItems");
	  List<Item> items = itemService.findAll();
	  mav.addObject("items", items);
	  return mav;
	 }
	 
	 @RequestMapping(value="/new", method=RequestMethod.GET)
	 public ModelAndView newItemForm()
	 {
	  ModelAndView mav = new ModelAndView("/items/newItem");
	  Item item = new Item();
	  mav.getModelMap().put("newItem", item);
	  return mav;
	 }
	 
	 @RequestMapping(value="/saveItem", method=RequestMethod.POST)
	 public String create(@ModelAttribute("newItem")Item item, BindingResult result, SessionStatus status) throws Exception
	 {
	  itemService.persist(item);
	  status.setComplete();
	  return "redirect:/items/all.html";
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView edit(@PathVariable Long id) throws Exception 
	 {
	  ModelAndView mav = new ModelAndView("/items/editItem");
	  Item item = itemService.findById(id);
	  mav.addObject("editItem", item);
	  return mav;
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	 public String update(@PathVariable Long id, @ModelAttribute("editItem") Item item, BindingResult result, SessionStatus status) throws Exception
	 {
	  itemService.merge(item);
	  status.setComplete();
	  return "redirect:/items/all.html";
	 }
	 
	 /*
	  * REST SERVICES
	  */
	
	 @RequestMapping(value="/all", method = RequestMethod.GET, produces={"application/json", "application/xml"} )
	 public @ResponseBody
	 List<Item> getItems() throws Exception{
			return itemService.findAll();
	 }
	 
	 @RequestMapping(value="/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public @ResponseBody Item getItem(@PathVariable Long id) throws Exception {
	 
			return itemService.findById(id);
	 
	 }
	 
	 @RequestMapping(value="/delete/{id}", method = RequestMethod.GET, produces={"application/json", "application/xml"})
	 public ModelAndView delete(@PathVariable Long id) throws Exception
	 {
	  ModelAndView mav = new ModelAndView("redirect:/items/all.html");
	  itemService.remove(id);
	  return mav;
	 } 

	 
	 
	
	
}
