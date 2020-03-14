/**
 * 
 */
package com.stackroute.favouriteservice.pubg.api.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ubuntu
 *
 */
public class Data {
	private String type;
	private String id;
	private Map<String,Object> attributes = new HashMap<String,Object>();
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
