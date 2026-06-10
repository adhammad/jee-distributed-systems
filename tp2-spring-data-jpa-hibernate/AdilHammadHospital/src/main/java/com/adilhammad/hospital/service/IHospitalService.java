package com.adilhammad.hospital.service;

import com.adilhammad.hospital.entities.Consultation;
import com.adilhammad.hospital.entities.Medecin;
import com.adilhammad.hospital.entities.Patient;
import com.adilhammad.hospital.entities.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m);
    RendezVous saveRendezVous(RendezVous r);
    Consultation saveConsultation(Consultation c);
}
