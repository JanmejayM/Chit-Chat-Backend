package com.user.application.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.application.entity.*;
import com.user.application.entity.UserInfo;
import com.user.application.exception.UserAlreadyExistsException;
import com.user.application.exception.UserNotExistException;
import com.user.application.repository.UserInfoRepository;

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	private UserInfoRepository repository;

	@Autowired
	private PasswordEncoder encoder;
	
	
	

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserInfo> userDetail = repository.findByEmailId(username);

		// Converting userDetail to UserDetails
		return userDetail.map(UserInfoDetails::new)
				.orElseThrow(() -> new UserNotExistException("User not found " + username));
		
		
	}

	public String addUser(UserInfo userInfo) {
		
	    Optional<UserInfo> u=repository.findByEmailId(userInfo.getEmailId());
	    
	    if(u.isPresent())
	    {
	    	throw new UserAlreadyExistsException("Already exists");
	    }
	    
	    else {
	    	
	    
	    
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		UserInfo newUser=repository.save(userInfo);
		
		return "Saved successfully";
		
		
		
	    }
	}
	
	public List<UserInfo> getUser()
	{
		return repository.findAll();
	}
	
	public UserInfo getUserById(long userid)
	{
		return repository.getById(userid);
	}
	
	public boolean loadDummyData(int numberOfData)
	{
		List<UserInfo>users=IntStream.range(1, numberOfData+1).mapToObj(i->new UserInfo(i,"omm"+String.valueOf(i), "omm"+String.valueOf(i)+"@gmail.com", encoder.encode("omm"+String.valueOf(i)), "USER")).collect(Collectors.toList());
		
		List<UserInfo>saved=repository.saveAll(users);
		
		if(saved.size()==numberOfData)

		{
			return true;
		}
		return false;
		
	}

}

