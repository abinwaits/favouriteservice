/**
 * 
 */
package com.stackroute.favouriteservice.service;

import java.util.List;

import com.stackroute.favouriteservice.dto.MatchResponse;
import com.stackroute.favouriteservice.dto.TournamentResponse;

/**
 * @author ubuntu
 *
 */
public interface IPubgService {

	TournamentResponse getTournamentDetails();

	MatchResponse getMatchDetails(String tournamentId,String matchId);

}
