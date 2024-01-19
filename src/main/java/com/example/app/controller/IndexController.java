package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.repository.MovieRepository;
import com.fasterxml.jackson.core.JacksonException;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

	private final MovieRepository movieRepository;

	@GetMapping({ "/", "/index" })
	public String showIndex(Model model) throws JacksonException {

		model.addAttribute("movieList", movieRepository.findPopularList(1));
		return "index";
	}
}
