package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import poly.store.dao.OrderDAO;
import poly.store.entity.Order;
import poly.store.service.OrderService;

@CrossOrigin("*")
@RestController
public class OrderRestController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDAO dao;
	
	@RequestMapping()
	public List<Order> getAll(){
		return orderService.findAll();
	}
	@PostMapping("/rest/orders")
	public Order create(@RequestBody JsonNode orderData ) {
		return orderService.create(orderData);
	}
	@GetMapping("/rest/unresolved")
	public List<Order> getUnresolved() {
		List<Order> a = dao.getUnresolved();
		return a;
		
	}
	@GetMapping("/rest/processing")
	public List<Order> getProcessing() {
		List<Order> a = dao.getProcessing();
		return a;
		
	}
	@GetMapping("/rest/processed")
	public List<Order> getProcessed() {
		List<Order> a = dao.getProcessed();
		return a;
		
	}
	@GetMapping("/rest/completed")
	public List<Order> getCompleted() {
		List<Order> a = dao.getCompleted();
		return a;
		
	}
	@PutMapping("/rest/order/processing/{id}")
	public Order updateStatus1(@PathVariable("id") Long id, Order order) {
		order =dao.getById(id);
		order.setStatus(2);
		return dao.save(order);
	}
	@PutMapping("/rest/order/processed/{id}")
	public Order updateStatus2(@PathVariable("id") Long id, Order order) {
		order =dao.getById(id);
		order.setStatus(3);
		return dao.save(order);
	}
	@PutMapping("/rest/order/completed/{id}")
	public Order updateStatus3(@PathVariable("id") Long id, Order order) {
		order =dao.getById(id);
		order.setStatus(4);
		return dao.save(order);
	}
	
	

}
