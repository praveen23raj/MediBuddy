package com.practo.controller;

import com.practo.dto.PatientDto;
import com.practo.entity.Patient;
import com.practo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

   @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto dto){
        PatientDto patientDto = patientService.savePatient(dto);
        return new ResponseEntity<>(patientDto, HttpStatus.CREATED);
    }
}
