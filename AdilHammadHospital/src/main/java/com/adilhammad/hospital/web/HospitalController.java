package com.adilhammad.hospital.web;

import com.adilhammad.hospital.entities.Patient;
import com.adilhammad.hospital.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HospitalController {
    private final PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

}
