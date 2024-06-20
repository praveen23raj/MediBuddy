package com.practo.service;

import com.practo.dto.PatientDto;
import com.practo.entity.Patient;
import com.practo.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private ModelMapper modelMapper;


    public PatientDto savePatient(PatientDto dto){
        Patient patient = mapToEntity(dto);
        Patient saved = patientRepo.save(patient);
        PatientDto patientDto = mapToDto(saved);
        return patientDto;

    }


    public Patient mapToEntity(PatientDto dto){
        Patient Entity = modelMapper.map(dto, Patient.class);
        return Entity;
    }

    public PatientDto mapToDto(Patient patient){
        PatientDto dto = modelMapper.map(patient, PatientDto.class);
        return dto;
    }
}
