package com.lanz.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanz.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
