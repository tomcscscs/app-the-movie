package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.model.Movie;
import com.example.app.model.MovieList;
import com.example.app.repository.MovieRepository;
import com.fasterxml.jackson.core.JacksonException;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

	private final MovieRepository movieRepository;

	@GetMapping({ "/", "/index" })
	public String showIndex(Model model) throws JacksonException {
		MovieList popular = movieRepository.findPopularList(1);
		MovieList topRated = movieRepository.findTopRatedrList(1);

		List<Movie> recommend = List.of(popular.getResults().get(0), topRated.getResults().get(0));
		model.addAttribute("popular", popular);
		model.addAttribute("topRated", topRated);
		model.addAttribute("recommend", recommend);
		return "index";
	}
}
