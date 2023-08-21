package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.model.Detalle;
import idat.edu.pe.model.Ingreso;
import idat.edu.pe.model.Producto;
import idat.edu.pe.service.DetalleService;
import idat.edu.pe.service.IngresoService;
import idat.edu.pe.service.ProductoService;

@Controller
@RequestMapping("/detalle")
public class DetalleController {
    
    @Autowired
    private DetalleService service;

    @Autowired
    private IngresoService serviceIng;
    
    @Autowired
    private ProductoService servicePro;


    @RequestMapping("/listarTodo")
    public String listarDetalle(Model model) {
        List<Detalle> listarDetalle = service.buscarTodo();
        model.addAttribute("listarDetalle", listarDetalle);
        return "moduloDetalle/listarDetalle";
    }

    @RequestMapping("/nuevo")
    public String nuevoDetalle(Model model) {
        List<Ingreso> listaIngreso = serviceIng.buscarTodo();
        List<Producto> listaProducto = servicePro.buscarTodo();

        model.addAttribute("detalle", new Detalle());
        model.addAttribute("listaIngreso", listaIngreso);
        model.addAttribute("listaProducto", listaProducto);

        return "/moduloDetalle/nuevoDetalle";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearDetalle(@ModelAttribute("detalle") Detalle detalle) {
		service.crear(detalle);
		return "redirect:/detalle/listarTodo";
	}

    @RequestMapping(value = "/{id}")
	public String editarDetalle(@PathVariable("id") Integer id, Model model) {
        List<Ingreso> listaIngreso = serviceIng.buscarTodo();
        List<Producto> listaProducto = servicePro.buscarTodo();

        Detalle detalle = service.buscarPorId(id);
	    model.addAttribute("detalle", detalle);
        model.addAttribute("listaIngreso", listaIngreso);
        model.addAttribute("listaProducto", listaProducto);
        
        return "/moduloDetalle/nuevoDetalle";
	}

    @RequestMapping(value ="/eliminar/{id}")
	public String eliminarDetalle(@PathVariable(name = "id") Integer id) {
		service.borrarPorId(id);
		return "redirect:/detalle/listarTodo";
	}
}
