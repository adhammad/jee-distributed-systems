package com.adilhammad.hospital.service;

import com.adilhammad.hospital.entities.Consultation;
import com.adilhammad.hospital.entities.Medecin;
import com.adilhammad.hospital.entities.Patient;
import com.adilhammad.hospital.entities.RendezVous;
import com.adilhammad.hospital.repositories.ConsultationRepository;
import com.adilhammad.hospital.repositories.MedecinRepository;
import com.adilhammad.hospital.repositories.PatientRepository;
import com.adilhammad.hospital.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;
    private final RendezVousRepository rendezVousRepository;
    private final ConsultationRepository consultationRepository;
    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous r) {
        return rendezVousRepository.save(r);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consultationRepository.save(c);
    }
}
