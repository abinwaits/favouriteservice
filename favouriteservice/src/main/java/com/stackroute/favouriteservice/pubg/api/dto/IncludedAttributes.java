/**
 * 
 */
package com.stackroute.favouriteservice.pubg.api.dto;

import java.util.Map;

/**
 * @author ubuntu
 *
 */
public class IncludedAttributes {
	private Map<String,Object> stats;
    private String actor; 
    private String won;
    private String shardId;
	
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getWon() {
		return won;
	}
	public void setWon(String won) {
		this.won = won;
	}
	public String getShardId() {
		return shardId;
	}
	public void setShardId(String shardId) {
		this.shardId = shardId;
	}
	public Map<String, Object> getStats() {
		return stats;
	}
	public void setStats(Map<String, Object> stats) {
		this.stats = stats;
	}
    
    
	
}
