/**
 * 
 */
package com.stackroute.favouriteservice.dto;

import java.util.List;

/**
 * @author ubuntu
 *
 */
public class MatchDetails {
	
	private String tournamentId;
	private String matchId;
	private String titleId;
	private String gameMode;
	private String mapName;
	private String isCustomMatch;
	private String duration;
	private List<ParticipantDetails> participantDetails;
	
	
	public String getMatchId() {
		return matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public String getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
	public String getTitleId() {
		return titleId;
	}
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public String getMapName() {
		return mapName;
	}
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	public String getIsCustomMatch() {
		return isCustomMatch;
	}
	public void setIsCustomMatch(String isCustomMatch) {
		this.isCustomMatch = isCustomMatch;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public List<ParticipantDetails> getParticipantDetails() {
		return participantDetails;
	}
	public void setParticipantDetails(List<ParticipantDetails> participantDetails) {
		this.participantDetails = participantDetails;
	}
	
	
}
