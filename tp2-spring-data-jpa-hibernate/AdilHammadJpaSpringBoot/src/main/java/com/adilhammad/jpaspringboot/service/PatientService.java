package com.adilhammad.jpaspringboot.service;

import com.adilhammad.jpaspringboot.entities.Patient;
import com.adilhammad.jpaspringboot.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public Patient getPatientByid(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatientByName(String name) {
        return patientRepository.findByName(name);
    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }


}
