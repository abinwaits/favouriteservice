/**
 * 
 */
package com.stackroute.favouriteservice.pubg.api.dto;

import java.util.List;
import java.util.Map;

/**
 * @author ubuntu
 *
 */
public class TournamentData {
	private String type;
	private String id;
	private Map<String,Map<String,List<Data>>> relationships;
	private List<Data> included;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Map<String, Map<String, List<Data>>> getRelationships() {
		return relationships;
	}
	public void setRelationships(Map<String, Map<String, List<Data>>> relationships) {
		this.relationships = relationships;
	}
	public List<Data> getIncluded() {
		return included;
	}
	public void setIncluded(List<Data> included) {
		this.included = included;
	}
	
	
}
