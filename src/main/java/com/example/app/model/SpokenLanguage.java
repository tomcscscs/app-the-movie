package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SpokenLanguage {

	private String englishName;
	@JsonProperty("iso_639_1")
	private String iso639;
	private String name;
	
}
