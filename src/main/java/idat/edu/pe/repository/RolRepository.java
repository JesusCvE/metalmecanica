package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
}
