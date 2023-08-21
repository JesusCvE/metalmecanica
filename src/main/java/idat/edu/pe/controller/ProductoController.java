package idat.edu.pe.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.model.Producto;
import idat.edu.pe.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @RequestMapping("/ver")
    public String ver(Model model) {
        model.addAttribute("ver");
        return "/moduloProducto/detalleProducto";
    }

    @Autowired
    private ProductoService  service;

    @RequestMapping("/listarTodo")
    public String listarProducto(Model model) {
        List<Producto> listarProducto = service.buscarTodo();
        model.addAttribute("listarProducto", listarProducto);
        return "moduloProducto/listarProducto";
    }

    @RequestMapping("/nuevo")
    public String nuevoProducto(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "/moduloProducto/nuevoProducto";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearProducto(@ModelAttribute("producto") @RequestParam(name = "file", required = false)
                                MultipartFile foto, Producto producto) {
		
        if (!foto.isEmpty()) {
            String ruta = ".//src//main//resources//static//images/";

            try {
                byte[] bytes = foto.getBytes();
                Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
                Files.write(rutaAbsoluta, bytes);

                producto.setImagen((foto.getOriginalFilename()));
            } catch (Exception e) {
                //TODO: handle exception
            }
            service.crear(producto);
        }
		return "redirect:/producto/listarTodo";
	}

    @RequestMapping(value = "/{id}")
    public String editarProducto(@PathVariable("id") Integer id, Model model) {
        Producto producto = service.buscarPorId(id);
        model.addAttribute("producto", producto);
        return "moduloProducto/editarProducto";
    }

    // @RequestMapping(value = "/det/{id}")
    // public String detalleProducto(@PathVariable("id") Integer id, Model model) {
    //     Producto producto = service.buscarPorId(id);
    //     model.addAttribute("producto", producto);
    //     return "moduloProducto/detalleProducto";
    // }
    

     @RequestMapping(value = "/detalle/{id}")
	public ModelAndView detalleProducto(@PathVariable(name = "id") int id, Model model) {
	    ModelAndView mav = new ModelAndView("/editarProductos");
	     Producto producto = service.buscarPorId(id);
	   mav.addObject("producto", producto);
	    return mav;
	}

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name = "id") Integer id) {
        service.borrarPorId(id);
        return "redirect:/producto/listarTodo";
    }
}
