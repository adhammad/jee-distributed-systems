package com.adilhammad.hospital.repositories;

import com.adilhammad.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
