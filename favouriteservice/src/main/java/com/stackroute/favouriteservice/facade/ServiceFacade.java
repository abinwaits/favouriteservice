/**
 * 
 */
package com.stackroute.favouriteservice.facade;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

import com.stackroute.favouriteservice.pubg.api.dto.PubgApiMatchResponse;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiResponse;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiTDResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * @author ubuntu
 *
 */

@Component
public class ServiceFacade {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${tournamentsURI}")
	private String tournamentsURI;
	
	@Value("${tournamentDetailsURI}")
	private String tournamentDetailsURI;
	
	@Value("${matchURI}")
	private String matchURI;
	
	

	public PubgApiResponse getTournaments() {
		//final String uri = "https://api.pubg.com/tournaments";
		HttpHeaders headers = getHeaders();
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<PubgApiResponse> response = restTemplate.exchange(tournamentsURI, HttpMethod.GET, entity,
				PubgApiResponse.class);
		PubgApiResponse pubgApiResponse = response.getBody();
		return pubgApiResponse;
	}

	public PubgApiTDResponse getTournamentDetails(String tournamentId) {
		//String uri = "https://api.pubg.com/tournaments/eu-glls4";
		HttpHeaders headers = getHeaders();
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<PubgApiTDResponse> response = restTemplate.exchange(tournamentDetailsURI+tournamentId, HttpMethod.GET, entity,
				PubgApiTDResponse.class);
		PubgApiTDResponse pubgApiTDResponse = response.getBody();
		return pubgApiTDResponse;
	}

	public PubgApiMatchResponse getMatchDetails(String matchId) {
		HttpHeaders headers = getHeaders();
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<PubgApiMatchResponse> response = restTemplate.exchange(matchURI+matchId, HttpMethod.GET, entity,
				PubgApiMatchResponse.class);
		PubgApiMatchResponse pubgApiMatchResponse = response.getBody();
		return pubgApiMatchResponse;
	}
	
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiYjdkYzg2MC00MGZjLTAxMzgtYWEyOS01ZjExMjM0NDUzNWYiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNTgzNDA1MjkxLCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6ImFiaW53YWl0c2FtYXpvIn0.dsyX7Wih69WgAgXaR_896ht9z2vmM7tHfncHBixT71w");
		return headers;
	}
}
