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
import idat.edu.pe.model.Rol;
import idat.edu.pe.service.EmpleadoService;
import idat.edu.pe.service.RolService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService serviceEmp;

    @Autowired
    private RolService serviceRol;

    @RequestMapping("/listarTodo")
    public String listarEmpleado(Model model) {
        List<Empleado> listarEmpleado = serviceEmp.buscarTodo();
        model.addAttribute("listarEmpleado", listarEmpleado);
        return "moduloEmpleado/listarEmpleado";
    }

    @RequestMapping("/nuevo")
    public String nuevoEmpleado(Model model) {
        List<Rol> listaRol = serviceRol.buscarTodo();

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("listaRol", listaRol);

        return "/moduloEmpleado/nuevoEmpleado";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		serviceEmp.crear(empleado);
		return "redirect:/empleado/listarTodo";
	}

    @RequestMapping(value = "/{id}")
	public String editarEmpleado(@PathVariable("id") Integer id, Model model) {
        List<Rol> listaRol = serviceRol.buscarTodo();

        Empleado empleado = serviceEmp.buscarPorId(id);
        model.addAttribute("empleado", empleado);
        model.addAttribute("listaRol", listaRol);

        return "/moduloEmpleado/nuevoEmpleado";
    }

    @RequestMapping(value ="/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable(name = "id") int id) {
		serviceEmp.borrarPorId(id);
		return "redirect:/empleado/listarTodo";
	}
}
