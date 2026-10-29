

package com.example.healthManagement.service;

import com.example.healthManagement.Entity.Patient;
import com.example.healthManagement.Exeception.ResourceNotFound;
import com.example.healthManagement.dto.patientmapper;
import com.example.healthManagement.dto.PatientRequest;
import com.example.healthManagement.dto.PatientResponse;
import com.example.healthManagement.repository.patientrepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class patientService {

    private final patientrepo re;
    private final patientmapper pm;

    // Get all patients
    public List<PatientResponse> getAll() {
        return re.findAll()
                .stream()
                .map(pm::toResponse)
                .toList();
    }

    // Add patient
    public PatientResponse add(PatientRequest p) {

        if (re.findByPatientcode(p.getPatientcode()).isPresent()) {
            log.warn("Duplicate patient code");
            throw new ResourceNotFound("Patient code already exists");
        }

        if (p.getEmail() != null &&
                re.findByEmail(p.getEmail()).isPresent()) {
            log.warn("Duplicate email");
            throw new ResourceNotFound("Email already exists");
        }

        if (re.findByAadharNumber(p.getAadharNumber()).isPresent()) {
            log.warn("Duplicate Aadhar number");
            throw new ResourceNotFound("Aadhar number already exists");
        }

        if (re.findByPhoneNumber(p.getPhoneNumber()).isPresent()) {
            log.warn("Duplicate phone number");
            throw new ResourceNotFound("Phone number already exists");
        }

        Patient patient = pm.toEntity(p);
        Patient savedPatient = re.save(patient);

        log.info("Patient added successfully");

        return pm.toResponse(savedPatient);
    }

    // Get patient by ID
    public PatientResponse getId(Long id) {

        Patient patient = re.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound("Patient ID not found: " + id));

        return pm.toResponse(patient);
    }

    // Update patient
    public PatientResponse update(PatientRequest p, Long id) {

        Patient oldPatient = re.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound("Patient ID not found: " + id));

//        oldPatient.setPatientcode(p.getPatientcode());
//        oldPatient.setFirstName(p.getFirstName());
//        oldPatient.setLastName(p.getLastName());
//        oldPatient.setAge(p.getAge());
//        oldPatient.setGender(p.getGender());
//        oldPatient.setPhoneNumber(p.getPhoneNumber());
//        oldPatient.setEmail(p.getEmail());
//        oldPatient.setBloodGroup(p.getBloodGroup());
//        oldPatient.setAadharNumber(p.getAadharNumber());
//        oldPatient.setAddress(p.getAddress());
//        oldPatient.setEmergencyContact(p.getEmergencyContact());
//        oldPatient.setAdmitDate(p.getAdmitDate());
//        oldPatient.setStatus(p.getStatus());

        Patient updatedPatient = re.save(oldPatient);

        log.info("Patient updated successfully");

        return pm.toResponse(updatedPatient);
    }

    // Delete patient
    public void delete(Long id) {

        Patient patient = re.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFound("Patient ID not found: " + id));

        re.delete(patient);

        log.info("Patient deleted successfully");
    }
}