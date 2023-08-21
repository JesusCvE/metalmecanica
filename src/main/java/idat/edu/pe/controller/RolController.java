package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.model.Rol;
import idat.edu.pe.service.RolService;

@Controller
@RequestMapping("/rol")
public class RolController {
    
    @Autowired
    private RolService service;

    @RequestMapping("/listarTodo")
    public String listarRol(Model model) {
        List<Rol> listarRol = service.buscarTodo();
        model.addAttribute("listarRol", listarRol);
        return "moduloRol/listarRol";
    }

    @RequestMapping("/nuevo")
    public String nuevoRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "/moduloRol/nuevoRol";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearRol(@ModelAttribute("rol") Rol rol) {
		service.crear(rol);
		return "redirect:/rol/listarTodo";
	}

    @RequestMapping(value = "/{id}")
	public String editarRol(@PathVariable("id") Integer id, Model model) {
        Rol rol = service.buscarPorId(id);
	    model.addAttribute("rol", rol);
        return "/moduloRol/nuevoRol";
	}

    @RequestMapping(value ="/eliminar/{id}")
	public String eliminarRol(@PathVariable(name = "id") Integer id) {
		service.borrarPorId(id);
		return "redirect:/rol/listarTodo";
	}
}
