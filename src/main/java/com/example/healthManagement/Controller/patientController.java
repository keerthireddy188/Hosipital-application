
package com.example.healthManagement.Controller;

import com.example.healthManagement.dto.PatientRequest;
import com.example.healthManagement.dto.PatientResponse;
import com.example.healthManagement.service.patientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class patientController {

    private final patientService ps;

    // Get all patients
    @GetMapping("/all")
    public List<PatientResponse> getAll() {
        return ps.getAll();
    }

    // Get single patient
    @GetMapping("/{id}")
    public PatientResponse getId(@PathVariable Long id) {
        return ps.getId(id);
    }

    // Add patient
    @PostMapping("/add")
    public PatientResponse add(
            @Valid @RequestBody PatientRequest request) {
        return ps.add(request);
    }

    // Update patient
    @PutMapping("/update/{id}")
    public PatientResponse update(
            @Valid @RequestBody PatientRequest request,
            @PathVariable Long id) {
        return ps.update(request, id);
    }

    // Delete patient
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        ps.delete(id);
    }
}