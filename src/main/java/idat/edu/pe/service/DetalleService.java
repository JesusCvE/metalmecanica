package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.Detalle;
import idat.edu.pe.repository.DetalleRepository;

@Service
@Transactional
public class DetalleService {
    
    @Autowired
    DetalleRepository repository;

    public List<Detalle> buscarTodo() {
        return (List<Detalle>) repository.findAll();
    }

    public Detalle crear(Detalle detalle) {
        return repository.save(detalle);
    }

    public Detalle actualizar(Detalle detalleActualizar) {
        Detalle detalleActual = repository.findById(detalleActualizar.getIdDetaAlma()).get();

        detalleActual.setIdDetaAlma(detalleActualizar.getIdDetaAlma());
        detalleActual.setPreCompra(detalleActualizar.getPreCompra());
        detalleActual.setPreVenta(detalleActualizar.getPreVenta());
        detalleActual.setStockActu(detalleActualizar.getStockActu());
        detalleActual.setStockTotal(detalleActualizar.getStockTotal());
        detalleActual.setIngreso(detalleActualizar.getIngreso());
        detalleActual.setProducto(detalleActualizar.getProducto());

        Detalle detalleActualizado = repository.save(detalleActual);
        return detalleActualizado;
    }

    public Detalle buscarPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }
    
}
