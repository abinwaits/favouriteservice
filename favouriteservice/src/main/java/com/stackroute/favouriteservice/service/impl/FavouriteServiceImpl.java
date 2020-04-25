package com.stackroute.favouriteservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stackroute.favouriteservice.dao.FavouriteMatchesDAO;
import com.stackroute.favouriteservice.dto.MatchDetails;
import com.stackroute.favouriteservice.model.FavouriteMatches;
import com.stackroute.favouriteservice.model.FavouriteMatchesPK;
import com.stackroute.favouriteservice.service.IFavouriteService;
import com.stackroute.favouriteservice.dto.ApiResponse;

@Service
public class FavouriteServiceImpl implements IFavouriteService {

	@Autowired
	FavouriteMatchesDAO favouriteMatchesDAO;

	@Override
	public ApiResponse saveFavouriteMatch(MatchDetails matchDetails) {
		// TODO Auto-generated method stub
		FavouriteMatches favouriteMatches = null;
		ApiResponse apiResponse = new ApiResponse();
		if (matchDetails != null && !StringUtils.isEmpty(matchDetails.getEmailId())
				&& !StringUtils.isEmpty(matchDetails.getMatchId())) {
			FavouriteMatchesPK favouriteMatchesPK = new FavouriteMatchesPK(matchDetails.getEmailId(),
					matchDetails.getMatchId());
			favouriteMatches = new FavouriteMatches(favouriteMatchesPK, matchDetails.getTournamentId(),
					matchDetails.getTitleId(), matchDetails.getGameMode(), matchDetails.getMapName(),
					matchDetails.getDuration());
			favouriteMatchesDAO.save(favouriteMatches);
			apiResponse.setMessage("Match is saved successfully");
			apiResponse.setHttpStatus(HttpStatus.OK.value());
		}
		return apiResponse;
	}

	@Override
	public List<MatchDetails> getFavouriteMatches(String emailId) {
		// TODO Auto-generated method stub
		List<MatchDetails> matchDetailsList = new ArrayList<MatchDetails>();
		MatchDetails matchDetails = null;
		List<FavouriteMatches> favouriteMatchesList = favouriteMatchesDAO.findByFavouriteMatchesPKEmailId(emailId);
		if (favouriteMatchesList != null && !favouriteMatchesList.isEmpty()) {
			for (FavouriteMatches match : favouriteMatchesList) {
				if (match != null) {
					matchDetails = new MatchDetails();
					if (match.getFavouriteMatchesPK() != null) {
						matchDetails.setEmailId(match.getFavouriteMatchesPK().getEmailId());
						matchDetails.setMatchId(match.getFavouriteMatchesPK().getMatchId());
					}
					matchDetails.setTournamentId(match.getTournamentId());
					matchDetails.setTitleId(match.getTitleId());
					matchDetails.setGameMode(match.getGameMode());
					matchDetails.setMapName(match.getMapName());
					matchDetails.setDuration(match.getDuration());
					matchDetails.setIsFavourite(true);
					matchDetailsList.add(matchDetails);
				}
			}
		}
		return matchDetailsList;
	}

	@Override
	public Boolean isMatchExists(String emailId, String matchId) {
		Boolean isExists = false;
		FavouriteMatchesPK favouriteMatchesPK = new FavouriteMatchesPK(emailId, matchId);
		Optional<FavouriteMatches> favouriteMatches = favouriteMatchesDAO.findById(favouriteMatchesPK);
		if (favouriteMatches != null && !favouriteMatches.isEmpty()) {
			isExists = true;
		}
		return isExists;
	}

	@Override
	public ApiResponse deleteFavouriteMatch(String emailId, String matchId) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();

		FavouriteMatchesPK favouriteMatchesPK = new FavouriteMatchesPK(emailId, matchId);
		FavouriteMatches favouriteMatches = new FavouriteMatches(favouriteMatchesPK);
		favouriteMatchesDAO.delete(favouriteMatches);
		apiResponse.setMessage("Match is deleted successfully");
		apiResponse.setHttpStatus(HttpStatus.OK.value());
		return apiResponse;
	}

}
