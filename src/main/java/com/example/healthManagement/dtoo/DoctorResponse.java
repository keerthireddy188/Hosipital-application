package com.example.healthManagement.dtoo;

import com.example.healthManagement.Enum.gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {

    private Long id;
    private String doctorcode;
    private String firstName;
    private String LastName;
    private String age;
    private gender gender;
    private String phoneNumber;
    private String email;
    private String specialization;
    private String aadharNumber;
    private String address;
    private String emergencyContact;
    private String status;
}
