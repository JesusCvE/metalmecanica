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

import idat.edu.pe.model.Garantia;
import idat.edu.pe.service.GarantiaService;

@Controller
@RequestMapping("/garantia")
public class GarantiaController {
    
    @Autowired
    private GarantiaService service;
    
    @RequestMapping("/listarTodo")
    public String listarGarantia(Model model) {
        List<Garantia> listarGarantia = service.buscarTodo();
        model.addAttribute("listarGarantia", listarGarantia);
        return "moduloGarantia/listarGarantia";
    }

    @RequestMapping("/nuevo")
    public String nuevoGarantia(Model model) {
        model.addAttribute("garantia", new Garantia());
        return "moduloGarantia/nuevoGarantia";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearGarantia(@ModelAttribute("garantia") @RequestParam(name = "file", required = false)
    MultipartFile foto, Garantia garantia) {
		
        if (!foto.isEmpty()) {
            String ruta = ".//src//main//resources//static//images/";

            try {
                byte[] bytes = foto.getBytes();
                Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
                Files.write(rutaAbsoluta, bytes);

                garantia.setImg((foto.getOriginalFilename()));
            } catch (Exception e) {
                //TODO: handle exception
            }
            service.crear(garantia);
        }
		return "redirect:/garantia/listarTodo";
	}

    @RequestMapping(value = "/{id}")
	public String editarGarantia(@PathVariable("id") Integer id, Model model) {
        Garantia garantia = service.buscarPorId(id);
	    model.addAttribute("garantia", garantia);
        return "/moduloGarantia/nuevoGarantia";
	}

    @RequestMapping(value ="/eliminar/{id}")
	public String eliminarGarantia(@PathVariable(name = "id") Integer id) {
		service.borrarPorId(id);
		return "redirect:/garantia/listarTodo";
	}
}
