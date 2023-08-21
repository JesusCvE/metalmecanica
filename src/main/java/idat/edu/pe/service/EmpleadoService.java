package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.Empleado;
import idat.edu.pe.repository.EmpleadoRepository;

@Service
@Transactional
public class EmpleadoService {
    
    @Autowired
    EmpleadoRepository repository;

    public List<Empleado> buscarTodo() {
        return (List<Empleado>) repository.findAll();
    }

    public Empleado crear(Empleado empleado) {
        return repository.save(empleado);
    }

    public Empleado actualizar(Empleado empleadoActualizar) {
        Empleado empleadoActual = repository.findById(empleadoActualizar.getIdEmpleado()).get();

        empleadoActual.setIdEmpleado(empleadoActualizar.getIdEmpleado());
        empleadoActual.setNombres(empleadoActualizar.getNombres());
        empleadoActual.setApellidos(empleadoActualizar.getApellidos());
        empleadoActual.setNroDoc(empleadoActualizar.getNroDoc());
        empleadoActual.setSexo(empleadoActualizar.getSexo());
        empleadoActual.setNacimiento(empleadoActualizar.getNacimiento());
        empleadoActual.setTelefono(empleadoActualizar.getTelefono());
        empleadoActual.setEmail(empleadoActualizar.getEmail());
        empleadoActual.setPass(empleadoActualizar.getPass());
        empleadoActual.setRol(empleadoActualizar.getRol());

        Empleado empleadoActualizado = repository.save(empleadoActual);
        return empleadoActualizado;
    }

    public Empleado buscarPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }

}
