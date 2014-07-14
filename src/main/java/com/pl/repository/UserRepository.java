package com.pl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pl.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
