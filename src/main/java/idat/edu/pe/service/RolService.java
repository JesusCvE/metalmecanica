package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.Rol;
import idat.edu.pe.repository.RolRepository;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository repository;

    public List<Rol> buscarTodo() {
		return (List<Rol>) repository.findAll();
	}

    public Rol crear(Rol rol) {
        return repository.save(rol);
    }

    public Rol actualizar(Rol rolActualizar) {
        Rol rolActual = repository.findById(rolActualizar.getIdRol()).get();

        // rolActual.setIdRol(rolActualizar.getIdRol());
        rolActual.setNombre(rolActualizar.getNombre());
        rolActual.setEstado(rolActualizar.getEstado());

        Rol rolActualizado = repository.save(rolActual);
        return rolActualizado;
    }

    public Rol buscarPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }
}
