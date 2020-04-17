package com.stackroute.favouriteservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.favouriteservice.model.FavouriteMatches;
import com.stackroute.favouriteservice.model.FavouriteMatchesPK;

public interface FavouriteMatchesDAO extends JpaRepository<FavouriteMatches,FavouriteMatchesPK>{
	
	List<FavouriteMatches> findByFavouriteMatchesPKEmailId(String emailId);
}
