package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.model.ProDetalle;

@Repository
public interface ProDetalleRepository extends JpaRepository<ProDetalle, Integer> {
    
}
