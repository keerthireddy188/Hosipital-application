package com.example.healthManagement.Entity;

import com.example.healthManagement.Enum.bloodgroup;
import com.example.healthManagement.Enum.gender;
import com.example.healthManagement.Enum.patientstatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)

    private String Patientcode;
    @Column(nullable = false)

    private String firstName;
    @Column(nullable = false)

    private  String LastName;
    @Column(nullable = true,length =20)

    private String age;


    @Enumerated(EnumType.STRING)
    private gender gender;
    @Column(nullable = false,unique = true)

    private String PhoneNumber;
    @Column(nullable = true,unique = true)

    private String email;
    @Enumerated(EnumType.STRING)
    private bloodgroup bloodGroup;
    @Column(nullable = false,unique = true)

    private String aadharNumber;
    @Column(nullable = true)

    private String address;
    @Column(nullable = false)

    private String emergencyContact;
    @Column(nullable = false)

    private String admitDate;
    @Enumerated(EnumType.STRING)
    private patientstatus status;

}
