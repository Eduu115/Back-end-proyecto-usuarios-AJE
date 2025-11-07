package aje.restcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aje.model.entities.Usuario;
import aje.model.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/todos")
	public ResponseEntity<?> todos(){
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@PostMapping("/api/usuarios/login")
	 public ResponseEntity<?> login(@AuthenticationPrincipal Usuario usuario) {
	        // Si llega aquí, ya está autenticado por Spring Security (HTTP Basic)
	        

	        return ResponseEntity.ok().body(usuario);
	    }
	
	@PostMapping("/registro")
	 public ResponseEntity<?> registro(@RequestBody Usuario usuario) {
	        // Si llega aquí, ya está autenticado por Spring Security (HTTP Basic)
	        usuarioService.registrar(usuario);

	        return ResponseEntity.ok().body(usuario);
	    }
	
	@GetMapping("/rol/{rol}")
	
	public ResponseEntity<List<Usuario>> porrol(@PathVariable int rol){
		
		
		return ResponseEntity.ok().body(usuarioService.findByPerfil(rol));
		
	}
	
	

}
