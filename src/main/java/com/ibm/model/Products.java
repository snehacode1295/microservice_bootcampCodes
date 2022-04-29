package com.ibm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="products")
public class Products {
	@Id
	long id;
	String name,added_on;
	long category_id;
	double price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAdded_on() {
		return added_on;
	}
	public void setAdded_on(String added_on) {
		this.added_on = added_on;
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public Products(long id, String name, double price, String added_on, long category_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.added_on = added_on;
		this.category_id = category_id;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
