package com.adilhammad.hospital;

import com.adilhammad.hospital.entities.Consultation;
import com.adilhammad.hospital.entities.Medecin;
import com.adilhammad.hospital.entities.Patient;
import com.adilhammad.hospital.entities.RendezVous;
import com.adilhammad.hospital.entities.StatusRDV;
import com.adilhammad.hospital.repositories.ConsultationRepository;
import com.adilhammad.hospital.repositories.MedecinRepository;
import com.adilhammad.hospital.repositories.PatientRepository;
import com.adilhammad.hospital.repositories.RendezVousRepository;
import com.adilhammad.hospital.service.HospitalServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(HospitalServiceImpl hospitalService, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("Adil Hammad").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setName(name);
                medecin.setSpecialite("generaliste");
                medecin.setEmail("adil.hammad@gmail.com");
                hospitalService.saveMedecin(medecin);
            });

            Stream.of("Adil Hammad").forEach(name -> {
                Patient patient = new Patient();
                patient.setName(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(true);
                hospitalService.savePatient(patient);
            });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Medecin medecin = medecinRepository.findById(1L).orElse(null);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.DONE);
            hospitalService.saveRendezVous(rendezVous);

            Consultation consultation = new Consultation();
            consultation.setRendezVous(rendezVous);
            consultation.setDateConsultation(rendezVous.getDate());
            consultation.setRapport("consultation de " + patient.getName());
            hospitalService.saveConsultation(consultation);

        };
    }
}
