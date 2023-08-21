package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.Ingreso;
import idat.edu.pe.repository.IngresoRepository;

@Service
@Transactional
public class IngresoService {
    
    @Autowired
    IngresoRepository repository;

    public List<Ingreso> buscarTodo() {
        return (List<Ingreso>) repository.findAll();
    }

    public Ingreso crear(Ingreso ingreso) {
        return repository.save(ingreso);
    }

    public Ingreso actualizar(Ingreso ingresoActualizar) {
        Ingreso ingresoActual = repository.findById(ingresoActualizar.getIdIngreAlm()).get();

        ingresoActual.setFecha(ingresoActualizar.getFecha());
        ingresoActual.setPrecioTotal(ingresoActualizar.getPrecioTotal());
        ingresoActual.setIgv(ingresoActualizar.getPrecioTotal());
        ingresoActual.setProveedor(ingresoActualizar.getProveedor());
        ingresoActual.setEmpleado(ingresoActualizar.getEmpleado());

        Ingreso ingresoActualizado = repository.save(ingresoActual);
        return ingresoActualizado;
    }

    public Ingreso buscarPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }

}
