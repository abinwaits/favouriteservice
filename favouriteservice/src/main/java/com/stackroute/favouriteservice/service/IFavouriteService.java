/**
 * 
 */
package com.stackroute.favouriteservice.service;

import java.util.List;

import com.stackroute.favouriteservice.dto.ApiResponse;
import com.stackroute.favouriteservice.dto.MatchDetails;

/**
 * @author ubuntu
 *
 */
public interface IFavouriteService {
	
	ApiResponse saveFavouriteMatch(MatchDetails matchDetails);
	
	List<MatchDetails> getFavouriteMatches(String emailId);
	
	Boolean isMatchExists(String emailId, String matchId);
	
	ApiResponse deleteFavouriteMatch(String emailId, String matchId);
}
