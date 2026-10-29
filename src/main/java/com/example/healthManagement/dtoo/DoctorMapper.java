package com.example.healthManagement.dtoo;


import com.example.healthManagement.Entity.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toEntity(DoctorRequest request);

    DoctorResponse toResponse(Doctor doctor);
}
