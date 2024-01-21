package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.repository.MovieRepository;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

	private final MovieRepository movieRepository;

	@GetMapping({ "/", "/index" })
	public String showIndex(Model model) throws JacksonException {

		model.addAttribute("movieList", movieRepository.findPopularList(1));
		model.addAttribute("indexTopRated", movieRepository.findTopRatedList(1));
		return "index";
	}
	
	@GetMapping("/popular")
	public String showThePopularMore(Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("movieListDuplicator", movieRepository.findPopularList(1));
		return "popularMore";
		
	}
	
	@GetMapping("/topRated")
	public String showTopRatedMore(Model model) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("movieListTopRateAll", movieRepository.findTopRatedList(1));
		return "topRatedMore";
		
	}
	
	@GetMapping("/movie/{movieId}")
	public String showPopularDetail(Model model,@PathVariable int movieId) throws JsonMappingException, JsonProcessingException {
		model.addAttribute("showPopularDetail", movieRepository.findPopularMovieDetailsById(movieId));
		return  "popularDetail";
		
	
	}
	

	 
	
	
}
