/**
 * 
 */
package com.stackroute.favouriteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favouriteservice.facade.ServiceFacade;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiMatchResponse;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiResponse;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiTDResponse;

/**
 * @author ubuntu
 *
 */

@RestController
@CrossOrigin(origins = "*")
public class PubgController {
	
	@Autowired
	ServiceFacade serviceFacade;
	
	@GetMapping("/tournaments")
	public PubgApiResponse getTournaments() {
		return serviceFacade.getTournaments();
	}
	
	@GetMapping("/tournaments/{id}")
	public PubgApiTDResponse getTournamentDetails(@PathVariable String id) {
		return serviceFacade.getTournamentDetails(id);
	}
	
	@GetMapping("/tournament/matches/{id}")
	public PubgApiMatchResponse getMatchDetails(@PathVariable String id) {
		return serviceFacade.getMatchDetails(id);
	}

}
