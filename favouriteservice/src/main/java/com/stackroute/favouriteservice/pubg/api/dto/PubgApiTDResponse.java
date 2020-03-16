/**
 * 
 */
package com.stackroute.favouriteservice.pubg.api.dto;

import java.util.List;

/**
 * @author ubuntu
 *
 */
public class PubgApiTDResponse {
	private TournamentData data;
	private List<Data> included;

	public TournamentData getData() {
		return data;
	}

	public void setData(TournamentData data) {
		this.data = data;
	}

	public List<Data> getIncluded() {
		return included;
	}

	public void setIncluded(List<Data> included) {
		this.included = included;
	}
	
	
}
