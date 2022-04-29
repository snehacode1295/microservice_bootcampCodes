package com.ibm.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
	@Id
    @GeneratedValue
    private Long id;
    private String productName;
    private long userid;
    private int quantity;
    private double productPrice;

    public OrderItem(Long id, String productName, int quantity, double productPrice, long userid) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.productPrice=productPrice;
		this.userid= userid;
	}
    public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public double getPrice() {
        return (productPrice*quantity);
    }

	
	
}
