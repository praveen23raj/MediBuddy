package com.practo.controller;

import com.practo.entity.Doctor;
import com.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
        Doctor doc = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(doc, HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Doctor>> getDocotorByNameorSpecs(@PathVariable String name){
        List<Doctor> doctorsByNameOrSpecialization = doctorService.findDoctorsByNameOrSpecialization(name);
        return new ResponseEntity<>(doctorsByNameOrSpecialization,HttpStatus.OK);
    }
}
