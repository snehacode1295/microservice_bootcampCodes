package com.ibm.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.model.OrderItem;

public interface OrderRepository extends JpaRepository<OrderItem, Long> {
	
	OrderItem findByProductName(String productName);

	List<OrderItem> findByUserid(long userid);
}