/**
 * 
 */
package com.stackroute.favouriteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favouriteservice.dto.MatchResponse;
import com.stackroute.favouriteservice.dto.TournamentResponse;
import com.stackroute.favouriteservice.facade.ServiceFacade;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiMatchResponse;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiResponse;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiTDResponse;
import com.stackroute.favouriteservice.service.IPubgService;

/**
 * @author ubuntu
 *
 */

@RestController
@CrossOrigin(origins = "*")
public class PubgController {

	@Autowired
	ServiceFacade serviceFacade;

	@Autowired
	IPubgService pubgService;

	@GetMapping("/api/tournaments")
	public PubgApiResponse getTournaments() {
		return serviceFacade.getTournaments();
	}

	@GetMapping("/api/tournaments/{id}")
	public PubgApiTDResponse getTournamentDetails(@PathVariable String id) {
		return serviceFacade.getTournamentDetails(id);
	}

	@GetMapping("/api/tournament/matches/{id}")
	public PubgApiMatchResponse getApiMatchDetails(@PathVariable String id) {
		return serviceFacade.getMatchDetails(id);
	}

	// Exposed services

	@GetMapping("/tournaments")
	public TournamentResponse getTournamentDetails() {
		return pubgService.getTournamentDetails();
	}

	@GetMapping("/tournament/matches/{tournamentid}/{matchid}/{emailid}")
	public MatchResponse getMatchDetails(@PathVariable String tournamentid, @PathVariable String matchid, @PathVariable String emailid) {
		return pubgService.getMatchDetails(tournamentid, matchid, emailid);
	}

}
