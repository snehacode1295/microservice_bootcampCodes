package com.ibm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.AddtoCart;
import com.ibm.model.CheckoutCart;
import com.ibm.model.OrderItem;
import com.ibm.model.Products;
import com.ibm.repository.AddToCartRepo;
import com.ibm.repository.CheckoutRepo;
import com.ibm.repository.OrderRepository;


@Service
public class CartSerivceImpl implements CartService {

	@Autowired
	AddToCartRepo addCartRepo;
	@Autowired
	CheckoutRepo checkOutRepo;
	@Autowired
	ProductServices proServices;
	@Autowired
	OrderRepository orderRepo;
    private static final Logger logger = LoggerFactory.getLogger(CartSerivceImpl.class);

	@Override
	public List<AddtoCart> addCartbyUserIdAndProductId(long productId, long userId,int qty,double price) throws Exception {
		try {
			if(addCartRepo.getCartByProductIdAnduserId(userId, productId).isPresent()){
				throw new Exception("Product is already exist.");
			}
			AddtoCart obj = new AddtoCart();
			obj.setQty(qty);
			obj.setUser_id(userId);
			Products pro = proServices.getProductsById(productId);
			obj.setProduct(pro); 
			//TODO price has to check with qty
			obj.setPrice(price);
			obj.setAdded_date(new Date());
			addCartRepo.save(obj);		
			return this.getCartByUserId(userId);	
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public List<AddtoCart> getCartByUserId(long userId) {
		return addCartRepo.getCartByuserId(userId);
	}

	@Override
	public List<AddtoCart> removeCartByUserId(long cartId, long userId) {
		addCartRepo.deleteCartByIdAndUserId(userId, cartId);
		return this.getCartByUserId(userId);
	}

	@Override
	public void updateQtyByCartId(long cartId, int qty, double price) throws Exception {
		addCartRepo.updateQtyByCartId(cartId,price,qty);
	}

	@Override
	public Boolean checkTotalAmountAgainstCart(double totalAmount,long userId) {
		double total_amount =addCartRepo.getTotalAmountByUserId(userId);
		if(total_amount == totalAmount) {
			return true;
		}
		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
		return false;
	}

	@Override
	public List<CheckoutCart> getAllCheckoutByUserId(long userId) {
		return checkOutRepo.getByuserId(userId);
	}

	@Override
	public List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception {
		try {
			long user_id = tmp.get(0).getUser_id();
			if(tmp.size() >0) {
				checkOutRepo.saveAll(tmp);
				this.removeAllCartByUserId(user_id);
				
				List<OrderItem> orders= new ArrayList<OrderItem>();
				for(CheckoutCart order : tmp) {
					OrderItem cart = new OrderItem();
					cart.setQuantity(order.getQty());
					cart.setUserid(order.getUser_id());
					cart.setProductName(order.getProduct().getName());
					cart.setProductPrice(order.getPrice());
					orders.add(cart);
				}
				orderRepo.saveAll(orders);
				return this.getAllCheckoutByUserId(user_id);
			}	
			else {
				throw  new Exception("Should not be empty");
			}
		}catch(Exception e) {
			throw new Exception("Error while checkout "+e.getMessage());
		}
		
	}

	@Override
	public List<AddtoCart> removeAllCartByUserId(long userId) {
		addCartRepo.deleteAllCartByUserId(userId);
		return null;
	}

}
