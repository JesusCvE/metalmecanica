package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.model.Garantia;

@Repository
public interface GarantiaRepository extends JpaRepository<Garantia, Integer> {
    
}
