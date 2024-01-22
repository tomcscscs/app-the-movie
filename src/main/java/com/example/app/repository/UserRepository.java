package com.example.app.repository;

import com.example.app.model.User;

public interface UserRepository {
	
	public User findById(String id);
}
