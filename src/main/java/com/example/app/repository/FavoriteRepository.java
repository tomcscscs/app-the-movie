package com.example.app.repository;

import java.util.List;

import com.example.app.model.Favorite;

public interface FavoriteRepository {

	public int save(Favorite one);
	
	public List<Favorite> findAllByUserId(String userId);
	
	public int deleteById(Integer id);
	
}
