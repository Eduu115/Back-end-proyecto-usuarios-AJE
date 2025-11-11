package aje.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aje.model.entities.Usuario;
import aje.repository.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(username).orElse(null);
	}

	@Override
	public Usuario findById(String username) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(username).orElse(null);
	}

	@Override
	public Usuario findByUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario registrar(Usuario usuario) {
        usuario.setPassword("{noop}"+usuario.getPassword());
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> findByPerfil(int idPerfil) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByPerfil_IdPerfil(idPerfil);
	}

}
