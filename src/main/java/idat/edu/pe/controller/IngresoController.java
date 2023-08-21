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
import idat.edu.pe.model.Ingreso;
import idat.edu.pe.model.Proveedor;
import idat.edu.pe.service.EmpleadoService;
import idat.edu.pe.service.IngresoService;
import idat.edu.pe.service.ProveedorService;

@Controller
@RequestMapping("/ingreso")
public class IngresoController {
    
    @Autowired
    private IngresoService service;

    @Autowired
    private EmpleadoService serviceEmp;

    @Autowired
    private ProveedorService servicePro;

    @RequestMapping("/listarTodo")
    public String listarIngreso(Model model) {
        List<Ingreso> listarIngreso = service.buscarTodo();
        model.addAttribute("listarIngreso", listarIngreso);
        return "moduloIngreso/listarIngreso";
    }

    @RequestMapping("/nuevo")
    public String nuevoIngreso(Model model) {
        List<Empleado> listaEmpleado = serviceEmp.buscarTodo();
        List<Proveedor> listaProveedor = servicePro.buscarTodo();

        model.addAttribute("ingreso", new Ingreso());
        model.addAttribute("listaEmpleado", listaEmpleado);
        model.addAttribute("listaProveedor", listaProveedor);

        return "/moduloIngreso/nuevoIngreso";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearIngreso(@ModelAttribute("ingreso") Ingreso ingreso) {
		service.crear(ingreso);
		return "redirect:/ingreso/listarTodo";
	}

    @RequestMapping(value = "/{id}")
	public String editarIngreso(@PathVariable("id") Integer id, Model model) {
        List<Empleado> listaEmpleado = serviceEmp.buscarTodo();
        List<Proveedor> listaProveedor = servicePro.buscarTodo();

        Ingreso ingreso = service.buscarPorId(id);
	    model.addAttribute("ingreso", ingreso);
        model.addAttribute("listaEmpleado", listaEmpleado);
        model.addAttribute("listaProveedor", listaProveedor);
        
        return "/moduloIngreso/nuevoIngreso";
	}

    @RequestMapping(value ="/eliminar/{id}")
	public String eliminarIngreso(@PathVariable(name = "id") Integer id) {
		service.borrarPorId(id);
		return "redirect:/ingreso/listarTodo";
	}
}
