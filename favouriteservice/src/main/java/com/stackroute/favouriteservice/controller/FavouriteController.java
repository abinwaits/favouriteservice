package com.stackroute.favouriteservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public List<MatchDetails> getFavouriteMatches(@PathVariable String emailid) {
		return favouriteService.getFavouriteMatches(emailid);
	}

	@DeleteMapping("/favouritematch/{emailid}/{matchid}")
	public ResponseEntity<ApiResponse> deleteFavouriteMatches(@PathVariable String emailid,
			@PathVariable String matchid) {
		ResponseEntity<ApiResponse> responseEntity = null;
		ApiResponse apiResponse = favouriteService.deleteFavouriteMatch(emailid, matchid);
		if (apiResponse != null) {
			if (apiResponse.getHttpStatus() == 200) {
				responseEntity = new ResponseEntity(apiResponse, HttpStatus.OK);
			} else if (apiResponse.getHttpStatus() == 400) {
				responseEntity = new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
			}
		}
		return responseEntity;
	}

}
