package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.model.Ingreso;

@Repository
public interface IngresoRepository extends JpaRepository<Ingreso, Integer> {
    
}
