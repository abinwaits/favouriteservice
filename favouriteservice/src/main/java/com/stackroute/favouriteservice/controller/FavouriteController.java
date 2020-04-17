package com.stackroute.favouriteservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favouriteservice.dto.MatchDetails;
import com.stackroute.favouriteservice.service.IFavouriteService;
import com.stackroute.favouriteservice.dto.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
public class FavouriteController {
	
	@Autowired
	IFavouriteService favouriteService;
	
	@PostMapping("/favouritematch")
	public ApiResponse saveFavouriteMatch(@RequestBody MatchDetails matchDetails) {
		return favouriteService.saveFavouriteMatch(matchDetails);
	}
	
	@GetMapping("/favouritematch/{emailid}")
	public List<MatchDetails> getFavouriteMatches(@PathVariable String emailid){
		return favouriteService.getFavouriteMatches(emailid);
	}
	
	@DeleteMapping("/favouritematch/{emailid}/{matchid}")
	public ApiResponse getFavouriteMatches(@PathVariable String emailid,@PathVariable String matchid){
		return favouriteService.deleteFavouriteMatch(emailid,matchid);
	}
	

}
