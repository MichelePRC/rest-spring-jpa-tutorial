package org.slevin.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slevin.common.Item;
import org.slevin.common.Order;
import org.slevin.dao.ItemsDao;
import org.slevin.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class persistenceTests {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	OrdersDao orderDao;

	@Autowired
	ItemsDao itemDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final String BASE_URL = "http://localhost:8080/rest-spring-jpa-tutorial/";  
	


	@Test
	@Transactional
	public void testDaoImpl() throws Exception {
		Item itemTest = new Item();
		itemTest.setProduct("new product");
		itemTest.setPrice(120.00);
		itemTest.setQuantity(1100);
		itemDao.persist(itemTest);
		assertEquals(1, itemDao.count());
	}
	
	@Test
	public void testItemRestServices() throws Exception {
		// test Rest template get by id  
		Map<String, Long> vars = Collections.singletonMap("id", itemDao.findAll().get(0).getId());
	    Item item = restTemplate.getForObject(BASE_URL+"items/{id}", Item.class, vars);  
	    System.out.println("ItemRestTest "+item.getProduct());
	    assertNotNull("no item",item);  
	}
	

	@Test
	@Transactional
	public void testDaoServices() throws Exception {
		Order order = new Order();
		order.getItems().add(new Item());
		orderDao.persist(order);
		assertEquals(1, orderDao.count());
	}

	@Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {
		Order order = new Order();
		order.getItems().add(new Item());
		entityManager.persist(order);
		entityManager.flush();
		assertNotNull(order.getId());
	}

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		Order order = new Order();
		order.getItems().add(new Item());
		entityManager.persist(order);
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		Order other = (Order) entityManager.find(Order.class, order.getId());
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

	@Test
	@Transactional
	public void testSaveAndFind() throws Exception {
		Order order = new Order();
		Item item = new Item();
		item.setProduct("foo");
		order.getItems().add(item);
		entityManager.persist(order);
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		Order other = (Order) entityManager
				.createQuery(
						"select o from Order o join o.items i where i.product=:product")
				.setParameter("product", "foo").getSingleResult();
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

}
