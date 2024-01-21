package com.example.app.repository;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.app.model.MovieDetailField;
import com.example.app.model.MovieList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class MovieRepository {

	public MovieDetailField findPopularMovieDetailsById(int movieId) throws JsonMappingException, JsonProcessingException {
		RestTemplate template = new RestTemplate();

		String url = "https://api.themoviedb.org/3/movie/" + movieId + "?";
		url += "api_key=679e9857895a2235f19bffa7a33e7494&";
		url += "language=ko-KR&";

		ResponseEntity<MovieDetailField> response = template.exchange(url, HttpMethod.GET, null, MovieDetailField.class);

		return response.getBody();
		
		
	}

	
	
	public MovieList findPopularList(int page) throws JsonMappingException, JsonProcessingException {
		RestTemplate template = new RestTemplate();

		String url = "https://api.themoviedb.org/3/movie/popular?";
		url += "api_key=679e9857895a2235f19bffa7a33e7494&";
		url += "language=ko-KR&";
		url += "page=" + page;

		ResponseEntity<MovieList> response = template.exchange(url, HttpMethod.GET, null, MovieList.class);

		return response.getBody();

		/*
		 * ResponseEntity<String> response = template.exchange(url, HttpMethod.GET,
		 * null, String.class);
		 * 
		 * String resposneBody = response.getBody();
		 * 
		 * ObjectMapper mapper = new ObjectMapper(); return
		 * mapper.readValue(resposneBody, MovieList.class);
		 */
	}
	
	public MovieList findTopRatedList(int page) throws JsonMappingException, JsonProcessingException {
		RestTemplate template = new RestTemplate();

		String url = "https://api.themoviedb.org/3/movie/top_rated?";
		url += "api_key=679e9857895a2235f19bffa7a33e7494&";
		url += "language=ko-KR&";
		url += "page=" + page;

		ResponseEntity<MovieList> response = template.exchange(url, HttpMethod.GET, null, MovieList.class);

		return response.getBody();
	}
	
	
	
	
}
