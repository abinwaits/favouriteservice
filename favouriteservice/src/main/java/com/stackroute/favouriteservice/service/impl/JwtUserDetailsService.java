package com.stackroute.favouriteservice.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stackroute.favouriteservice.dao.UserDetailsDAO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.stackroute.favouriteservice.model.UserDetails userDetailsDB = userDetailsDAO.findByEmailId(username);
		if (userDetailsDB != null && !StringUtils.isEmpty(userDetailsDB.getEmailId())) {
			return new User(username, userDetailsDB.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
