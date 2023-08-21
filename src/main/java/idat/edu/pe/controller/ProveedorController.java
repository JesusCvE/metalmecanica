package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.model.Proveedor;
import idat.edu.pe.service.ProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
    
    @Autowired
    private ProveedorService service;

    @RequestMapping("/listarTodo")
    public String listarProveedor(Model model) {
        List<Proveedor> listarProveedor = service.buscarTodo();
        model.addAttribute("listarProveedor", listarProveedor);
        return "moduloProveedor/listarProveedor";
    }

    @RequestMapping("/nuevo")
    public String nuevoProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "/moduloProveedor/nuevoProveedor";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
		service.crear(proveedor);
		return "redirect:/proveedor/listarTodo";
	}

    @RequestMapping(value = "/{id}")
	public String editarProveedor(@PathVariable("id") Integer id, Model model) {
        Proveedor proveedor = service.buscarPorId(id);
        model.addAttribute("proveedor", proveedor);
        return "/moduloProveedor/nuevoProveedor";
    }

    @RequestMapping(value ="/eliminar/{id}")
	public String eliminarProveedor(@PathVariable(name = "id") int id) {
		service.borrarPorId(id);
		return "redirect:/proveedor/listarTodo";
	}
}
