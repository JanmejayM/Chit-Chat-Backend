package com.user.application.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.application.entity.AuthRequest;
import com.user.application.entity.UserInfo;
import com.user.application.payload.UserDto;
import com.user.application.repository.UserInfoRepository;
import com.user.application.service.JwtService;
import com.user.application.service.UserInfoService;




@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserInfoService service;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private UserInfoService userDetailsService;
	
	
	@Autowired
	private UserInfoRepository repository;


		

	@PostMapping("/addNewUser")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}
	
	@PostMapping("/loadDummyData/{numberOfData}")
	public boolean loadDummyData(@PathVariable int numberOfData) {
		return service.loadDummyData(numberOfData);
	}
	
	
	


	@PostMapping("/generateToken")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			System.out.println(authentication.isAuthenticated());
			return jwtService.generateToken(authRequest.getUsername());
		} else {
			throw new RuntimeException("invalid user request !");
		}
	}
	
	@GetMapping("/userdetails")
	public List<UserInfo> getProfiles() {
		return service.getUser();
		
	}
	
	
	@GetMapping("/user/Profile")
	public UserDto userProfile(@RequestHeader("Authorization")String authHeader) {
		String token = null;
		String username = null;
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			username = jwtService.extractUsername(token);

		}
		
		Optional<UserInfo> userDetail = repository.findByEmailId(username);

		UserDto user=new UserDto(userDetail.get());
		
		return user;
		
		
	}
	
	
	

}

