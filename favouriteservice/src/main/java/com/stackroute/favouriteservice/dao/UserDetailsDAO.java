package com.stackroute.favouriteservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.favouriteservice.model.UserDetails;

public interface UserDetailsDAO extends JpaRepository<UserDetails,String>{
	
	UserDetails findByEmailId(String emailId);

}
