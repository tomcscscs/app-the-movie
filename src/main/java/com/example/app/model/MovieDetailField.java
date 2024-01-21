package com.example.app.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class MovieDetailField {
	private Integer id;
	@JsonProperty("orgianl_title")
	private String originalTitle;
	@JsonProperty("poster_path")
	private String posterPath;
	
	private String overview;
	
	@JsonProperty("release_date")
	private Date releaseDate;
	
	private Integer runtime;
	@JsonProperty("vote_average")
	private double voteAverage;
	

}
