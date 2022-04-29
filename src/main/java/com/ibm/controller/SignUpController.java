package com.ibm.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.model.User;
import com.ibm.pojo.ApiResponse;
import com.ibm.repository.UserRepository;
import com.ibm.service.UserService;


@RestController
@RequestMapping("api/signup")
public class SignUpController {
	@Autowired
	  UserService userservice;
	@Autowired
	UserRepository userrepo;
	@PostMapping("user")
	public ResponseEntity<?> userLogin(@RequestBody HashMap<String,String> signupRequest) {
		try {
			//TODO validation has to add for client request
			User user = userservice.signUpUser(signupRequest);

			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(user.getLoginID()).toUri();
					return ResponseEntity.created(location)
							.body(user);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
		@GetMapping("{allUser}")
		public ResponseEntity<Optional<User>> userList(@PathVariable Long id) {
				//TODO validation has to add for client request
				Optional<User> user = userrepo.findById(id);
				return  ResponseEntity.ok(user);
		
	}
}
