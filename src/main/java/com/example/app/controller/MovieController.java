package com.example.app.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.app.model.Favorite;
import com.example.app.model.Genre;
import com.example.app.model.MovieDetails;
import com.example.app.model.User;
import com.example.app.repository.FavoriteRepository;
import com.example.app.repository.MovieRepository;
import com.fasterxml.jackson.core.JacksonException;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

	private final MovieRepository movieRepository;
	private final FavoriteRepository favoriteRepository;

	@GetMapping("/{movieId}")
	public String showSpecificMovieDetail(@PathVariable int movieId, Model model) {
		MovieDetails details = movieRepository.findMovieDetailsById(movieId);
		model.addAttribute("movie", details);

		return "movie/details";
	}

	@GetMapping("/popular")
	public String showPopularMovies(@RequestParam(defaultValue = "1") int page, Model model) throws JacksonException {

		model.addAttribute("movie", movieRepository.findPopularList(page));

		return "movie/list";
	}

	@GetMapping("/top-rated")
	public String showTopRatedMovie(@RequestParam(defaultValue = "1") int page, Model model) throws JacksonException {

		model.addAttribute("movie", movieRepository.findTopRatedrList(page));

		return "movie/list";
	}

	// 즐겨찾기 추가 - AJAX
	@PostMapping("/favorite/{movieId}")
	@ResponseBody
	public Map<String, Object> proceedAddFavorite(@PathVariable Integer movieId, @SessionAttribute User logonUser) {
		List<Favorite> favorites = favoriteRepository.findAllByUserId(logonUser.getId());
		boolean exist = false;
		for (Favorite f : favorites) {
			if (f.getMovieId().equals(movieId)) {
				exist = true;
				break;
			}
		}
		Map<String, Object> response = new LinkedHashMap<>();
		if (exist) {
			response.put("result", false);
			response.put("cause", "이미 즐겨찾기에 추가된 영화입니다.");
			return response;
		}

		Favorite favorite = new Favorite();
		favorite.setMovieId(movieId);
		favorite.setUserId(logonUser.getId());
		MovieDetails details = movieRepository.findMovieDetailsById(movieId);
		favorite.setMovieTitle(details.getTitle());
		String genres = "";
		for (Genre one : details.getGenres()) {
			genres += one.getName() + ",";
		}
		favorite.setMovieGenres(genres);
		favoriteRepository.save(favorite);
		response.put("result", true);
		return response;
	}
	// 즐겨찾기 삭제

}
