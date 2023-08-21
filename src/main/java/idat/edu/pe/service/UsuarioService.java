package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.model.Usuario;
import idat.edu.pe.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository repository;

    public List<Usuario> buscarTodo() {
        return (List<Usuario>) repository.findAll();
    }

    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario actualizar(Usuario usuarioActualizar) {
        Usuario usuarioActual = repository.findById(usuarioActualizar.getIdUsuario()).get();

        usuarioActual.setIdUsuario(usuarioActualizar.getIdUsuario());
        usuarioActual.setTipoDoc(usuarioActualizar.getTipoDoc());
        usuarioActual.setNroDoc(usuarioActualizar.getNroDoc());
        usuarioActual.setUserNom(usuarioActualizar.getUserNom());
        usuarioActual.setUserApe(usuarioActualizar.getUserApe());
        usuarioActual.setSexo(usuarioActualizar.getSexo());
        usuarioActual.setNacimiento(usuarioActualizar.getNacimiento());
        usuarioActual.setDireccion(usuarioActualizar.getDireccion());
        usuarioActual.setTelefono(usuarioActualizar.getTelefono());
        usuarioActual.setEmail(usuarioActualizar.getEmail());
        usuarioActual.setPass(usuarioActualizar.getPass());

        Usuario usuarioActualizado = repository.save(usuarioActual);
        return usuarioActualizado;
    }

    public Usuario buscarPorId(Integer id) {
        return repository.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repository.deleteById(id);
    }
}
