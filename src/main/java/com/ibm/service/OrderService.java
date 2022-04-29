package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.OrderItem;
import com.ibm.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepo;
	
	public List<OrderItem> findOrders(long userid)  throws Exception {
		
		List<OrderItem> orders=orderRepo.findByUserid(userid);
		return orders;
		
	}
}
