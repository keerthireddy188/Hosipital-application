package com.example.healthManagement.repository;

import com.example.healthManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface patientrepo extends JpaRepository<Patient, Long> {

    Optional<Patient> findByPatientcode(String patientcode);

    Optional<Patient> findByEmail(String email);

    Optional<Patient> findByPhoneNumber(String phoneNumber);

    Optional<Patient> findByAadharNumber(String aadharNumber);
}