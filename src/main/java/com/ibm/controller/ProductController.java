package com.ibm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.Category;
import com.ibm.model.Products;
import com.ibm.service.ProductServices;

@RestController
@RequestMapping("api/product")
public class ProductController {
	@Autowired
	ProductServices ProductServices;
	
	@GetMapping("getAll")
	public List<Products> getAllPRoducts(){
		return ProductServices.getAllProducts();
	}
	@GetMapping("getAllCategory")
	public List<Category> getAllCategory(){
		return ProductServices.getAllCategory();
	}
	@GetMapping("getProductsByCategory")
	public List<Products> getProductsByCategory(@RequestBody HashMap<String,String> request){
		String category_id = request.get("cat_id");		
		return ProductServices.getProductsByCategory(category_id);
	}
	
}
