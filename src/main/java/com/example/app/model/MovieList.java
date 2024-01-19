package com.example.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MovieList {
	private Integer page;
	
	@JsonProperty("total_pages")
	private Integer totalPages;
	
	@JsonProperty("total_results")
	private Integer totalResults;
	
	private List<Movie> results;
}
