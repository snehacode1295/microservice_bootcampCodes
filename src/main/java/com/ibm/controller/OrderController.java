package com.ibm.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.jwtconfig.ShoppingConfiguration;
import com.ibm.model.AddtoCart;
import com.ibm.model.CheckoutCart;
import com.ibm.model.OrderItem;
import com.ibm.pojo.ApiResponse;
import com.ibm.service.CartService;
import com.ibm.service.OrderService;
import com.ibm.service.ProductServices;


@RestController
@RequestMapping("api/order")
public class OrderController {
	@Autowired
	CartService cartService;
	@Autowired
	ProductServices proService;
	@Autowired
	OrderService orderService;
	@PostMapping("checkout_order")
  	public ResponseEntity<?> checkout_order(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"userId","total_price","pay_type","deliveryAddress"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
				
				
			}
			long user_Id = Long.parseLong(addCartRequest.get("userId"));
			double total_amt = Double.parseDouble(addCartRequest.get("total_price"));
			if(cartService.checkTotalAmountAgainstCart(total_amt,user_Id)) {
				List<AddtoCart> cartItems = cartService.getCartByUserId(user_Id);
				List<CheckoutCart> tmp = new ArrayList<CheckoutCart>();
				for(AddtoCart addCart : cartItems) {
					String orderId = ""+getOrderId();
					CheckoutCart cart = new CheckoutCart();
					cart.setPayment_type(addCartRequest.get("pay_type"));
					cart.setPrice(total_amt);
					cart.setUser_id(user_Id);
					cart.setOrder_id(orderId);
					cart.setProduct(addCart.getProduct());
					cart.setQty(addCart.getQty());
					cart.setDelivery_address(addCartRequest.get("deliveryAddress"));
					cart.setOrder_date(new Date());
					tmp.add(cart);
				}
				cartService.saveProductsForCheckout(tmp);
				
						return ResponseEntity.status(HttpStatus.OK)
								.body(new ApiResponse("Order placed successfully").getMessage());
				//return ResponseEntity.ok(new ApiResponse("Order placed successfully"));
			}else {
				throw new Exception("Total amount is mismatch");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	public int getOrderId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	@GetMapping("/orderall/{userid}")
	public ResponseEntity<?> getOrder(@PathVariable long userid) {
		try {
			String keys[] = {"userId"};
			List<OrderItem> obj = orderService.findOrders(userid);
			return ResponseEntity.ok(obj);
		}catch(Exception e) {
				return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
}
	}
