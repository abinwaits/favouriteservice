package com.stackroute.favouriteservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.stackroute.favouriteservice.dto.ApiResponse;
import com.stackroute.favouriteservice.dto.MatchDetails;

public class FavouriteControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void saveFavouriteMatch() throws Exception {
		String uri = "/favouritematch";
		MatchDetails matchDetails = new MatchDetails();
		matchDetails.setEmailId("abin@gmail.com");
		matchDetails.setMatchId("M1");
		matchDetails.setTournamentId("T1");
		matchDetails.setTitleId("Title Test");
		matchDetails.setGameMode("Game Mode Test");
		matchDetails.setMapName("Map Name Test");
		matchDetails.setDuration("120");
		String inputJson = super.mapToJson(matchDetails);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson).headers(getHeaders(getToken()))).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ApiResponse apiResponse = super.mapFromJson(content, ApiResponse.class);
		assertEquals(apiResponse.getMessage(), "Match is saved successfully");
	}
	
	@Test
	public void getFavouriteMatches() throws Exception {
		String uri = "/favouritematch/abin@gmail.com";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(getHeaders(getToken()))).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
	}
	
	@Test
	public void deleteFavouriteMatches() throws Exception {
		String uri = "/favouritematch/abin@gmail.com/M1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(getHeaders(getToken()))).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ApiResponse apiResponse = super.mapFromJson(content, ApiResponse.class);
		assertEquals(apiResponse.getMessage(), "Match is deleted successfully");
	}

	private String getToken() throws Exception {
		String token = null;
		String authURI = "/authenticate/abin@gmail.com/Password123";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.post(authURI).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		token = mvcResult.getResponse().getContentAsString();
		return token;
	}

	private HttpHeaders getHeaders(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + token);
		return headers;
	}

}
