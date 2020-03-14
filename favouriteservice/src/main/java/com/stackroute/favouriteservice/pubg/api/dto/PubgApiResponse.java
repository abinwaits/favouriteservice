/**
 * 
 */
package com.stackroute.favouriteservice.pubg.api.dto;

import java.util.List;

/**
 * @author ubuntu
 *
 */
public class PubgApiResponse {
	private List<Data> data;
	
	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
		
}
