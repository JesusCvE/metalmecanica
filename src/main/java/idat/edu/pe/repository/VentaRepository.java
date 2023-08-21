package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    
}