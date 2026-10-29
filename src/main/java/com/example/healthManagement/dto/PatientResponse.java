package com.example.healthManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
    private long id;
    private String PatientCode;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String bloodgroup;
    private String emergenyContact;
    private String admitDate;
    private String status;


}
