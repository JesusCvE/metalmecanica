package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import idat.edu.pe.model.Carrito;

@Controller
public class CarritoController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/saveData")
    public void saveData(@RequestBody List<Carrito> items) {
        for (Carrito item : items) {
            jdbcTemplate.update(
                "INSERT INTO carritoItem (img, nombre, precio, cantidad) VALUES (?, ?, ?, ?)",
                item.getImg(), item.getNombre(), item.getPrecio(), item.getCantidad()
            );
        }
    }
}
