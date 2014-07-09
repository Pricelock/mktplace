package com.pl.service;

import java.io.Serializable;
import java.util.List;

import com.pl.domain.User;

public interface UserManager extends Serializable {
	
	public void increaseAge(int add);
	
	public List<User> getUsers();
	
}
