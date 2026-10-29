package com.example.healthManagement.dto;

import com.example.healthManagement.Entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface patientmapper {

    Patient toEntity(PatientRequest pt);

    PatientResponse toResponse(Patient s);

    void updatePatientFromRequests(
            PatientRequest Req,
            @MappingTarget Patient pt
    );
}