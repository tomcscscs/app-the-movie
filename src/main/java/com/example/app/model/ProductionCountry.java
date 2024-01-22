package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductionCountry {

	@JsonProperty("iso_3166_1")
	private String iso3166;
	private String name;

}
