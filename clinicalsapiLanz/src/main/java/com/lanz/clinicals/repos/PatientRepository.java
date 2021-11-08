package com.lanz.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanz.clinicals.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
