package com.adilhammad.jpaspringboot.web;

import com.adilhammad.jpaspringboot.entities.Patient;
import com.adilhammad.jpaspringboot.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patient")
    public List<Patient> getPatient() {
        return patientService.getAllPatient();
    }
}
