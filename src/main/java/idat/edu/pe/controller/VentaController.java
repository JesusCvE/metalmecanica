package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.model.Empleado;
import idat.edu.pe.model.Producto;
import idat.edu.pe.model.Usuario;
import idat.edu.pe.model.Venta;
import idat.edu.pe.service.EmpleadoService;
import idat.edu.pe.service.ProductoService;
import idat.edu.pe.service.UsuarioService;
import idat.edu.pe.service.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
    
    @Autowired
    private VentaService serviceVen;

    @Autowired
    private UsuarioService serviceUsu;

    @Autowired
    private EmpleadoService serviceEmp;

    @Autowired
    private ProductoService servicePro;

    @RequestMapping("/listarTodo")
    public String listarVenta(Model model) {
        List<Venta> listarVenta = serviceVen.buscarTodo();
        model.addAttribute("listarVenta", listarVenta);
        return "moduloVenta/listarVenta";
    }

    @RequestMapping("/nuevo")
    public String nuevoVenta(Model model) {
        List<Empleado> listaEmpleado = serviceEmp.buscarTodo();
        

        model.addAttribute("venta", new Venta());
        model.addAttribute("listaEmpleado", listaEmpleado);
        return "/moduloVenta/nuevoVenta";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearVenta(@ModelAttribute("venta") Venta venta) {
		serviceVen.crear(venta);
		return "redirect:/venta/listarTodo";
	}

    @RequestMapping(value = "/{id}")
	public String editarVenta(@PathVariable("id") Integer id, Model model) {
        List<Empleado> listaEmpleado = serviceEmp.buscarTodo();
        
        Venta venta = serviceVen.buscarPorId(id);
        model.addAttribute("venta", venta);
        model.addAttribute("listaEmpleado", listaEmpleado);
        return "/moduloVenta/detalleVenta";
    }

    @RequestMapping(value ="/eliminar/{id}")
	public String eliminarVenta(@PathVariable(name = "id") int id) {
		serviceVen.borrarPorId(id);
		return "redirect:/venta/listarTodo";
	}
}
