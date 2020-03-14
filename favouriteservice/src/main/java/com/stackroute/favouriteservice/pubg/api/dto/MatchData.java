/**
 * 
 */
package com.stackroute.favouriteservice.pubg.api.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ubuntu
 *
 */
public class MatchData {
	private String type;
	private String id;
	private Map<String,Object> attributes = new HashMap<String,Object>();
	private Map<String,Map<String,List<Data>>> relationships;
	
	public Map<String, Map<String, List<Data>>> getRelationships() {
		return relationships;
	}
	public void setRelationships(Map<String, Map<String, List<Data>>> relationships) {
		this.relationships = relationships;
	}
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
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	
}
