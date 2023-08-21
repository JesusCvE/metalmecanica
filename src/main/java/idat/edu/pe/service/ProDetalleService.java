package idat.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.ProDetalle;
import idat.edu.pe.repository.ProDetalleRepository;

@Service
public class ProDetalleService {
    
    @Autowired
    ProDetalleRepository repository;

    public List<ProDetalle> buscarTodo() {
        return (List<ProDetalle>) repository.findAll();
    }

    public ProDetalle crear(ProDetalle proDetalle) {
        return repository.save(proDetalle);
    }

    public ProDetalle actualizar(ProDetalle proDetalleActualizar) {
        ProDetalle proDetalleActual = repository.findById(proDetalleActualizar.getIdProducto()).get();

        proDetalleActual.setIdProducto(proDetalleActualizar.getIdProducto());
        proDetalleActual.setNombre(proDetalleActualizar.getNombre());
        proDetalleActual.setDescripcion(proDetalleActualizar.getDescripcion());
        proDetalleActual.setMarca(proDetalleActualizar.getMarca());
        proDetalleActual.setColor(proDetalleActualizar.getColor());
        proDetalleActual.setPrecio(proDetalleActualizar.getPrecio());
        proDetalleActual.setStock(proDetalleActualizar.getStock());
        proDetalleActual.setImagen(proDetalleActualizar.getImagen());
        proDetalleActual.setEstado(proDetalleActualizar.getEstado());

        ProDetalle proDetalleActualizado = repository.save(proDetalleActual);
        return proDetalleActualizado;
    }

    public ProDetalle buscarPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }
}
