package com.practo.repository;

import com.practo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

//    @Query("SELECT * FROM Doctor d WHERE d.doctorName = :name OR d.specialization = :name")
//    List<Doctor> findbyDocOrSpec(@Param("name") String name);

    @Query(name = "Doctor.findByDoctorNameOrSpecialization")
    List<Doctor> findByDoctorNameOrSpecialization(@Param("name") String name);

}