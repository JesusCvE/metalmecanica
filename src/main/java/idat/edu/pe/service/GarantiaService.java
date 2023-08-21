package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.Garantia;
import idat.edu.pe.repository.GarantiaRepository;

@Service
@Transactional
public class GarantiaService {
    
    @Autowired
    GarantiaRepository repository;

    public List<Garantia> buscarTodo() {
        return (List<Garantia>) repository.findAll();
    }

    public Garantia crear(Garantia garantia) {
        return repository.save(garantia);
    }

    public Garantia actualizar(Garantia garantiaActualizar) {
        Garantia garantiaActual = repository.findById(garantiaActualizar.getIdGarantia()).get();

        garantiaActual.setIdGarantia(garantiaActualizar.getIdGarantia());
        garantiaActual.setTipo(garantiaActualizar.getTipo());
        garantiaActual.setRazSocial(garantiaActualizar.getRazSocial());
        garantiaActual.setDocumento(garantiaActualizar.getDocumento());
        garantiaActual.setNombre(garantiaActualizar.getNombre());
        garantiaActual.setApellido(garantiaActualizar.getApellido());
        garantiaActual.setEmail(garantiaActualizar.getEmail());
        garantiaActual.setTelefono(garantiaActualizar.getTelefono());
        garantiaActual.setDescripcion(garantiaActualizar.getDescripcion());
        garantiaActual.setImg(garantiaActualizar.getImg());

        Garantia garantiaActualizado = repository.save(garantiaActual);
        return garantiaActualizado;
    }

    public Garantia buscarPorId(Integer id) {
        return repository.findById(id).get();
    }
    
    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }

}
