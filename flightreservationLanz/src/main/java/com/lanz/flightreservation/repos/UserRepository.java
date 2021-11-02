package com.lanz.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanz.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	 public User findByEmail(String email);

}
