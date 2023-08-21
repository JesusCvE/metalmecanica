package idat.edu.pe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.edu.pe.model.ProDetalle;
import idat.edu.pe.service.ProDetalleService;

@Controller
@RequestMapping("/prodetalle")
public class ProDetalleController {

    @Autowired
    private ProDetalleService  service;

    @RequestMapping("/ver")
    public String listarProducto(Model model) {
        List<ProDetalle> listarProDetalle = service.buscarTodo();
        model.addAttribute("proDetalle", listarProDetalle);
        return "moduloDetPro/listarProDetalle";
    }

    @RequestMapping(value = "/{id}")
    public String detalleProducto(@PathVariable("id") Integer id, Model model) {
        ProDetalle proDetalle = service.buscarPorId(id);
        model.addAttribute("producto", proDetalle);
        return "moduloDetPro/verProDetalle";
    }
    // @RequestMapping("/ver")
    // public String ver(Model model) {
    //     Producto producto = service.buscarTodo();
    //     model.addAttribute("detallepro", producto);
    //     return "moduloDetPro/listarDetalle";
    // }

    // @RequestMapping(value = "det/{id}")
    // public String editarProducto(@PathVariable("id") Integer id, Model model) {
    //     Producto producto = service.buscarPorId(id);
    //     model.addAttribute("detalle", producto);
    //     return "moduloProducto/detalleProducto";
    // }
}