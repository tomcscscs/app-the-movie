package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BelongsToCollection {
	private Integer id;
	private String name;
	@JsonProperty("poster_path")
	private String postPath;
	@JsonProperty("backdrop_path")
	private String backdropPath;
}
