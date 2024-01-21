package com.example.app.repository;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.app.model.MovieDetails;
import com.example.app.model.MovieList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class MovieRepository {

	public MovieDetails findMovieDetailsById(int movieId) {
		RestTemplate template = new RestTemplate();

		String url = "https://api.themoviedb.org/3/movie/" + movieId + "?";
		url += "api_key=679e9857895a2235f19bffa7a33e7494&";
		url += "language=ko-KR&";

		return null;
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
}
