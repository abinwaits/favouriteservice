package com.stackroute.favouriteservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.favouriteservice.dto.MatchDetails;
import com.stackroute.favouriteservice.dto.MatchResponse;
import com.stackroute.favouriteservice.dto.ParticipantDetails;
import com.stackroute.favouriteservice.dto.TournamentDetails;
import com.stackroute.favouriteservice.dto.TournamentResponse;
import com.stackroute.favouriteservice.facade.ServiceFacade;
import com.stackroute.favouriteservice.pubg.api.dto.Data;
import com.stackroute.favouriteservice.pubg.api.dto.IncludedAttributes;
import com.stackroute.favouriteservice.pubg.api.dto.IncludedData;
import com.stackroute.favouriteservice.pubg.api.dto.MatchData;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiMatchResponse;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiResponse;
import com.stackroute.favouriteservice.pubg.api.dto.PubgApiTDResponse;
import com.stackroute.favouriteservice.service.IPubgService;

@Service
public class PubgServiceImpl implements IPubgService {

	@Autowired
	ServiceFacade serviceFacade;

	@Override
	public TournamentResponse getTournamentDetails() {
		// TODO Auto-generated method stub
		TournamentResponse tournamentResponse = new TournamentResponse();
		List<TournamentDetails> tournamentDetailsList = new ArrayList<TournamentDetails>();
		TournamentDetails tournamentDetails = null;
		PubgApiTDResponse pubgApiTDResponse = null;
		List<MatchDetails> matchDetailsList = null;
		PubgApiResponse pubgApiResponse = serviceFacade.getTournaments();
		if (pubgApiResponse != null) {
			List<Data> dataList = pubgApiResponse.getData();
			if (dataList != null && !dataList.isEmpty()) {
				int i = 0;
				for (Data data : dataList) {
					tournamentDetails = new TournamentDetails();
					tournamentDetails.setTournamentId(data.getId());
					pubgApiTDResponse = serviceFacade.getTournamentDetails(tournamentDetails.getTournamentId());
					if (pubgApiTDResponse != null) {
						List<Data> tournamentDataList = pubgApiTDResponse.getIncluded();
						if (tournamentDataList != null && !tournamentDataList.isEmpty()) {
							matchDetailsList = new ArrayList<MatchDetails>();
							for (Data tData : tournamentDataList) {
								matchDetailsList.add(
										findMatchDetails(tournamentDetails.getTournamentId(), tData.getId(), false));
							}
							tournamentDetails.setMatchDetails(matchDetailsList);
						}
					}
					tournamentDetailsList.add(tournamentDetails);
					++i;
					if (i == 5) {
						break;
					}
				}
				tournamentResponse.setTournamentDetails(tournamentDetailsList);
			}
		}
		return tournamentResponse;
	}

	@Override
	public MatchResponse getMatchDetails(String tournamentId, String matchId) {
		// TODO Auto-generated method stub
		MatchResponse matchResponse = new MatchResponse();
		matchResponse.setMatchDetails(findMatchDetails(tournamentId, matchId, true));
		return matchResponse;
	}

	private MatchDetails findMatchDetails(String tournamentId, String matchId, boolean needParticipantDetails) {
		MatchDetails matchDetails = null;
		List<ParticipantDetails> participantDetailsList = null;
		ParticipantDetails participantDetails = null;
		PubgApiMatchResponse pubgApiMatchResponse = serviceFacade.getMatchDetails(matchId);
		if (pubgApiMatchResponse != null) {
			matchDetails = new MatchDetails();
			matchDetails.setTournamentId(tournamentId);
			MatchData data = pubgApiMatchResponse.getData();
			if (data != null) {
				matchDetails.setMatchId(data.getId());
				Map<String, Object> attributes = data.getAttributes();
				if (attributes != null && attributes.keySet() != null) {
					if (attributes.containsKey("titleId")) {
						matchDetails.setTitleId(String.valueOf(attributes.get("titleId")));
					}
					if (attributes.containsKey("gameMode")) {
						matchDetails.setGameMode(String.valueOf(attributes.get("gameMode")));
					}
					if (attributes.containsKey("mapName")) {
						matchDetails.setMapName(String.valueOf(attributes.get("mapName")));
					}
					if (attributes.containsKey("isCustomMatch")) {
						matchDetails.setIsCustomMatch(String.valueOf(attributes.get("isCustomMatch")));
					}
					if (attributes.containsKey("duration")) {
						matchDetails.setDuration(String.valueOf(attributes.get("duration")));
					}
				}
			}

			if (needParticipantDetails) {
				List<IncludedData> includedList = pubgApiMatchResponse.getIncluded();
				if (includedList != null && !includedList.isEmpty()) {
					participantDetailsList = new ArrayList<ParticipantDetails>();
					for (IncludedData includedData : includedList) {
						if (includedData.getType().equalsIgnoreCase("participant")) {
							participantDetails = new ParticipantDetails();
							IncludedAttributes attributes = includedData.getAttributes();
							Map<String, Object> stats = attributes.getStats();
							if (stats != null && stats.keySet() != null) {
								if (stats.containsKey("name")) {
									participantDetails.setName(String.valueOf(stats.get("name")));
								}
								if (stats.containsKey("deathType")) {
									participantDetails.setDeathType(String.valueOf(stats.get("deathType")));
								}
								if (stats.containsKey("vehicleDestroys")) {
									participantDetails.setVehicleDestroys(String.valueOf(stats.get("vehicleDestroys")));
								}
								if (stats.containsKey("weaponsAcquired")) {
									participantDetails.setWeaponsAcquired(String.valueOf(stats.get("weaponsAcquired")));
								}
								if (stats.containsKey("winPlace")) {
									participantDetails.setWinPlace(String.valueOf(stats.get("winPlace")));
								}
								if (stats.containsKey("killPlace")) {
									participantDetails.setKillPlace(String.valueOf(stats.get("killPlace")));
								}
							}
							participantDetailsList.add(participantDetails);
						}
					}
				}
				matchDetails.setParticipantDetails(participantDetailsList);
			}
		}
		return matchDetails;
	}

}
