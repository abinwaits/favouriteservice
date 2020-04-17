package com.stackroute.favouriteservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FavouriteMatchesPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6343255766588984617L;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "match_id")
	private String matchId;

	public FavouriteMatchesPK() {

	}

	public FavouriteMatchesPK(String emailId, String matchId) {
		this.emailId = emailId;
		this.matchId = matchId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

}
