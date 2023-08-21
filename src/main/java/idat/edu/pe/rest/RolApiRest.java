package idat.edu.pe.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.model.Rol;
import idat.edu.pe.service.RolService;

@RestController
@RequestMapping("/rest/rol")
public class RolApiRest {
    
    @Autowired
    private RolService service;

    @GetMapping
    public ResponseEntity<Object> buscarTodo() {
        List<Rol> listaRol = service.buscarTodo();
        System.out.println("LISTA DE ROLES : " + listaRol);
        return new ResponseEntity<>(listaRol, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Integer id) {
        Rol rol = service.buscarPorId(id);

        if (rol == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrada, Id porporcionado no es correcto");

        return new ResponseEntity<Object>(rol, HttpStatus.OK);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> crear(@RequestBody Rol rol) {
		service.crear(rol);
		return new ResponseEntity<Object>("Rol creada correctamente", HttpStatus.OK);
	}

    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> actualizar(@PathVariable("id") Integer id, @RequestBody Rol rol) {
		service.actualizar(rol);
		return new ResponseEntity<Object>("Rol actualizado correctamente", HttpStatus.OK);
	}
    
    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.borrarPorId(id);
		return new ResponseEntity<Object>("Rol eliminada correctamente", HttpStatus.OK);
	}
}
