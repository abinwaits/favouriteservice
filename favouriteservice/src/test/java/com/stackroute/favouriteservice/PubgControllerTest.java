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

import com.stackroute.favouriteservice.dto.MatchResponse;
import com.stackroute.favouriteservice.dto.TournamentResponse;

public class PubgControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getTournamentDetails() throws Exception {
		String uri = "/tournaments";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(getHeaders(getToken()))).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("content>>>"+content);
		TournamentResponse response = super.mapFromJson(content,TournamentResponse.class);
		assertNotNull(response.getTournamentDetails());
		
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

	@Test
	public void getMatchDetails() throws Exception {
		String uri = "/tournament/matches/kr-pgskr/46781ca3-7bd1-4419-88b9-9ee76f65eb2b/abin@gmail.com";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
				.headers(getHeaders(getToken()))).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("content>>>"+content);
		MatchResponse response = super.mapFromJson(content,MatchResponse.class);
		assertNotNull(response.getMatchDetails());
	}

	private HttpHeaders getHeaders(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + token);
		return headers;
	}

}
