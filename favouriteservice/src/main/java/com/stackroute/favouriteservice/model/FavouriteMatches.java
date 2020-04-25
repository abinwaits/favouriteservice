package com.stackroute.favouriteservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "favourite_matches")
public class FavouriteMatches implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8958363670684593441L;

	@EmbeddedId
	FavouriteMatchesPK favouriteMatchesPK;

	@Column(name = "tournament_id")
	private String tournamentId;

	@Column(name = "title_id")
	private String titleId;

	@Column(name = "game_mode")
	private String gameMode;

	@Column(name = "map_name")
	private String mapName;

	@Column(name = "duration")
	private String duration;

	public FavouriteMatches() {

	}
	
	public FavouriteMatches(FavouriteMatchesPK favouriteMatchesPK) {
		this.favouriteMatchesPK=favouriteMatchesPK;
	}

	public FavouriteMatches(FavouriteMatchesPK favouriteMatchesPK, String tournamentId, String titleId, String gameMode,
			String mapName, String duration) {
		this.favouriteMatchesPK=favouriteMatchesPK;
		this.tournamentId=tournamentId;
		this.titleId=titleId;
		this.gameMode=gameMode;
		this.mapName=mapName;
		this.duration=duration;
	}
	
	

	public FavouriteMatchesPK getFavouriteMatchesPK() {
		return favouriteMatchesPK;
	}

	public void setFavouriteMatchesPK(FavouriteMatchesPK favouriteMatchesPK) {
		this.favouriteMatchesPK = favouriteMatchesPK;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
