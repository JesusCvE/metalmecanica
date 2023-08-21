package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.model.Usuario;
import idat.edu.pe.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @RequestMapping("/login")
    private String iniciarSesion(Model model) {
        model.addAttribute("login");
        return "login";
    }
    
    @Autowired
    private UsuarioService service;

    @RequestMapping("/listarTodo")
    public String listarUsuario(Model model) {
        List<Usuario> listarUsuario = service.buscarTodo();
        model.addAttribute("listarUsuario", listarUsuario);
        return "moduloUsuario/listarUsuario";
    }

    @RequestMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/moduloUsuario/nuevoUsuario";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearUsuario(@ModelAttribute("usuario") Usuario usuario) {
		service.crear(usuario);
		return "redirect:/login";
	}

    @RequestMapping(value = "/{id}")
	public String editarUsuario(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = service.buscarPorId(id);
        model.addAttribute("usuario", usuario);
        return "/moduloUsuario/editarUsuario";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		service.crear(usuario);
		return "redirect:/usuario/listarTodo";
	}

    @RequestMapping(value ="/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(name = "id") int id) {
		service.borrarPorId(id);
		return "redirect:/usuario/listarTodo";
	}
}
