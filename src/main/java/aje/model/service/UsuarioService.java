package aje.model.service;

import java.util.List;

import aje.model.entities.Usuario;
import aje.model.entities.UsuarioDtoRegister;

public interface UsuarioService {
	
	Usuario findById(String username);
	Usuario findByUsernamePassword(String username, String password);
	List<Usuario> findAll();
	Usuario registrar(Usuario usuario);
	List<Usuario> findByPerfil(int idPerfil);
	Usuario toUsuario(UsuarioDtoRegister udto);
	
}
