/**
 * 
 */
package com.stackroute.favouriteservice.pubg.api.dto;

import java.util.Map;

/**
 * @author ubuntu
 *
 */
public class IncludedData {
	private String type;
	private String id;
	private MatchAttributes attributes;
	 
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
	public MatchAttributes getAttributes() {
		return attributes;
	}
	public void setAttributes(MatchAttributes attributes) {
		this.attributes = attributes;
	}
	
	
	
}
