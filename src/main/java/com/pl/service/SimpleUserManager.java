package com.pl.service;

import java.util.List;

import com.pl.domain.User;

public class SimpleUserManager implements UserManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<User> users;
	
	public void increaseAge(int add) {
		throw new UnsupportedOperationException();

	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
