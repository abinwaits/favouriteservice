/**
 * 
 */
package com.stackroute.favouriteservice.dto;

import java.util.List;

/**
 * @author ubuntu
 *
 */
public class TournamentDetails {
	private String tournamentId;
	List<MatchDetails> matchDetails;
	public String getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
	public List<MatchDetails> getMatchDetails() {
		return matchDetails;
	}
	public void setMatchDetails(List<MatchDetails> matchDetails) {
		this.matchDetails = matchDetails;
	}
	
	
}
