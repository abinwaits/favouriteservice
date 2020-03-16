package com.stackroute.favouriteservice.pubg.api.dto;

import java.util.List;
import java.util.Map;

public class PubgApiMatchResponse {
	private MatchData data;
	private List<IncludedData> included; 
	
	public MatchData getData() {
		return data;
	}

	public void setData(MatchData data) {
		this.data = data;
	}

	public List<IncludedData> getIncluded() {
		return included;
	}

	public void setIncluded(List<IncludedData> included) {
		this.included = included;
	}

		
}
