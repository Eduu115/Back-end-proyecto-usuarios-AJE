package aje.model.service;

import java.util.List;

import aje.model.entities.Rol;
import aje.model.entities.Usuario;

public interface UsuarioService {
	
	Usuario findById(String username);
	Usuario findByUsernamePassword(String username, String password);
	List<Usuario> findAll();
	Usuario registrar(Usuario usuario);
	List<Usuario> findByPerfil(int idPerfil);

}
