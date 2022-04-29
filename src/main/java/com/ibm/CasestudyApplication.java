package com.ibm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibm.model.Category;
import com.ibm.model.Products;
import com.ibm.model.User;
import com.ibm.repository.CategoryRepo;
import com.ibm.repository.ProductRepo;
import com.ibm.repository.UserRepository;


@SpringBootApplication
public class CasestudyApplication implements CommandLineRunner{
	@Autowired
	UserRepository userrepo;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryRepo categoryRepo;
	public static void main(String[] args) {
		SpringApplication.run(CasestudyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		User user = new User(1, "PPP", "sneha.ibm", "test", null, null, null, null, null, "1234");
		userrepo.save(user);	
		  Products products = new Products(1, "Coffee Mug", 80.00, "22-04-2022", 1);
		  productRepo.save(products);
		  
		  Category c= new Category(1,"Cup"); Category c1= new Category(2,"Umbrella");
		  List<Category> liCat= new ArrayList<>(); liCat.add(c); liCat.add(c1);
		  categoryRepo.saveAll(liCat);
		 
	}
	 

}
