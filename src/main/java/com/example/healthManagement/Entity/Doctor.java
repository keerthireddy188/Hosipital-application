
package com.example.healthManagement.Entity;

import com.example.healthManagement.Enum.gender;
import com.example.healthManagement.Enum.patientstatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String doctorcode;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String LastName;

    @Column(nullable = false)
    private String age;

    @Enumerated(EnumType.STRING)
    private gender gender;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false, unique = true)
    private String aadharNumber;

    @Column(nullable = true)
    private String address;

    @Column(nullable = false)
    private String emergencyContact;
    @Enumerated(EnumType.STRING)
    private patientstatus status;
}
