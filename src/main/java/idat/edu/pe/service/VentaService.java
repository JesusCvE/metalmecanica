package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.Venta;
import idat.edu.pe.repository.VentaRepository;

@Service
@Transactional
public class VentaService {
    
    @Autowired
    VentaRepository repository;

    public List<Venta> buscarTodo() {
        return (List<Venta>) repository.findAll();
    }

    public Venta crear(Venta venta) {
        return repository.save(venta);
    }

    public Venta actualizar(Venta ventaActualizar) {
        Venta ventaActual = repository.findById(ventaActualizar.getIdVenta()).get();

        ventaActual.setIdVenta(ventaActualizar.getIdVenta());
        ventaActual.setFecha(ventaActualizar.getFecha());
        ventaActual.setDocumento(ventaActual.getDocumento());
        ventaActual.setImporteTotal(ventaActualizar.getImporteTotal());
        ventaActual.setTipoComprobante(ventaActualizar.getTipoComprobante());
        ventaActual.setRuc(ventaActual.getRuc());
        ventaActual.setRazonSocial(ventaActual.getRazonSocial());
        ventaActual.setEmpleado(ventaActualizar.getEmpleado());

        Venta ventaActualizado = repository.save(ventaActual);
        return ventaActualizado;
    }

    public Venta buscarPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }

}
