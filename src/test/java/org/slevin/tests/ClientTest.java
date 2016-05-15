package org.slevin.tests;

import java.math.BigInteger;
import java.net.URI;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slevin.common.Item;
import org.slevin.common.Order;
import org.slevin.common.User;
import org.slevin.dao.ItemsDao;
import org.slevin.dao.OrdersDao;
import org.slevin.dao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


public class ClientTest {

	@Autowired
	RestTemplate restTemplate;
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/rest-spring-jpa-tutorial/";
    
    
     

    private static void getItem(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Item item = restTemplate.getForObject(REST_SERVICE_URI+"items/1", Item.class);
        System.out.println(item.getProduct());
    }
     

    private static void createRItem() {
        System.out.println("Testing create Ritem API----------");
        RestTemplate restTemplate = new RestTemplate();
        Item item=new Item();
        item.setProduct("macbook pro 15");
		item.setPrice(2000.00);
		item.setQuantity(5);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"restitems/newritem", item, Item.class);
        System.out.println("Location : "+uri.toASCIIString());
    } 
    
    
    
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user=new User();
        user.setEmail("m.procopio92@gmail.com");
        
        //User u2=restTemplate.postForObject(REST_SERVICE_URI+"users/newuser", user, User.class);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"users/newuser", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
        System.out.println(user);
    }
    
 
    public static void main(String args[]) throws Exception{
        getItem();
        createRItem();
        createUser();
      
    } 
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

