package com.example.app.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Favorite {

	private Integer id;
	private String userId;
	private Integer movieId;
	private String movieTitle;
	private String movieGenres;
	
}
