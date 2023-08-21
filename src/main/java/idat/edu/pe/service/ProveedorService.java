package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.Proveedor;
import idat.edu.pe.repository.ProveedorRepository;

@Service
@Transactional
public class ProveedorService {
    
    @Autowired
    ProveedorRepository repository;

    public List<Proveedor> buscarTodo() {
        return (List<Proveedor>) repository.findAll();
    }

    public Proveedor crear(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    public Proveedor actualizar(Proveedor proveedorActualizar) {
        Proveedor proveedorActual = repository.findById(proveedorActualizar.getIdProveedor()).get();

        proveedorActual.setIdProveedor(proveedorActualizar.getIdProveedor());
        proveedorActual.setTipoDoc(proveedorActualizar.getTipoDoc());
        proveedorActual.setNroDoc(proveedorActualizar.getNroDoc());
        proveedorActual.setRazSocial(proveedorActualizar.getRazSocial());
        proveedorActual.setDireccion(proveedorActualizar.getDireccion());
        proveedorActual.setTelefono(proveedorActualizar.getTelefono());
        proveedorActual.setEmail(proveedorActualizar.getEmail());

        Proveedor proveedorActualizado = repository.save(proveedorActual);
        return proveedorActualizado;
    }

    public Proveedor buscarPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }
}
