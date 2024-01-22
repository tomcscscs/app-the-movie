package com.example.app.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MovieDetails {
	private Boolean adult;
	@JsonProperty("backdrop_path")
	private String backdropPath;
	@JsonProperty("belongs_to_collection")
	private BelongsToCollection belongsToCollection;
	private Integer budget;
	private List<Genre> genres;

	private String hamepage;
	private Integer id;
	@JsonProperty("imdb_id")
	private String imdbId;
	@JsonProperty("original_language")
	private String originalLanguage;
	@JsonProperty("original_title")
	private String originalTitle;
	private String overview;
	private Double popularity;

	@JsonProperty("poster_path")
	private String posterPath;
	@JsonProperty("production_companies")
	private List<ProductionCompany> productionCompanies;
	@JsonProperty("production_countries")
	private List<ProductionCountry> productionCountries;
	@JsonProperty("release_date")
	private Date releaseDate;
	private Integer revenue;
	private Integer runtime;

	@JsonProperty("spoken_languages")
	private List<SpokenLanguage> spokenLanguages;

	private String status;
	private String tagline;
	private String title;
	private Boolean video;
	@JsonProperty("vote_average")
	private Double voteAverage;
	@JsonProperty("vote_count")
	private Integer voteCount;

}
