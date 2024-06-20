package com.practo.service;

import com.practo.entity.Doctor;
import com.practo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepo;

    public Doctor createDoctor(Doctor doctor){
        Doctor save = doctorRepo.save(doctor);
        return save;


    }

//    public List<Doctor> findByDocNameOrSpecs(String name) {
//        List<Doctor> doctors = doctorRepo.findbyDocOrSpec(name);
//        return doctors;
//    }

    public List<Doctor> findDoctorsByNameOrSpecialization(String name) {
        return doctorRepo.findByDoctorNameOrSpecialization(name);
    }
}
