package com.practo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctor")
@NamedQuery(
        name = "Doctor.findByDoctorNameOrSpecialization",
        query = "SELECT d FROM Doctor d WHERE d.doctorName = :name OR d.specialization = :name"
)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

    @Column(name = "qualification", nullable = false)
    private String qualification;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "experience", nullable = false)
    private int experience;

}