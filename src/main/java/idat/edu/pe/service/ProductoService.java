package idat.edu.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.Producto;
import idat.edu.pe.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository repository;

    public List<Producto> buscarTodo() {
        return (List<Producto>) repository.findAll();
    }

    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizar(Producto productoActualizar) {
        Producto productoActual = repository.findById(productoActualizar.getIdProducto()).get();

        productoActual.setIdProducto(productoActualizar.getIdProducto());
        productoActual.setNombre(productoActualizar.getNombre());
        productoActual.setDescripcion(productoActualizar.getDescripcion());
        productoActual.setMarca(productoActualizar.getMarca());
        productoActual.setColor(productoActualizar.getColor());
        productoActual.setPrecio(productoActualizar.getPrecio());
        productoActual.setStock(productoActualizar.getStock());
        productoActual.setImagen(productoActualizar.getImagen());
        productoActual.setEstado(productoActualizar.getEstado());

        Producto productoActualizado = repository.save(productoActual);
        return productoActualizado;
    }

    public Producto buscarPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }
}
