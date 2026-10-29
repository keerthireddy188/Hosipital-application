
package com.example.healthManagement.dto;

import com.example.healthManagement.Enum.bloodgroup;
import com.example.healthManagement.Enum.gender;
import com.example.healthManagement.Enum.patientstatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {

    @NotBlank(message = "required")
    private String patientcode;

    @NotBlank(message = "Name is required")
    private String firstName;

    @NotBlank(message = "required")
    private String LastName;

    @NotNull(message = "age is required")
    private String age;

    @NotNull(message = "gender is required")
    private gender gender;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "invalid phoneNumber")
    private String phoneNumber;

    @Email(message = "invalid mail format")
    private String email;

    @NotNull(message = "required")
    private bloodgroup bloodGroup;

    @NotNull(message = "required")
    private String aadharNumber;

    @NotNull(message = "required")
    private String address;

    @NotBlank(message = "required")
    private String emergencyContact;

    @NotNull(message = "required")
    private String admitDate;

    @NotNull(message = "required")
    private patientstatus status;
}
