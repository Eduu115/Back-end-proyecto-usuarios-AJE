package aje.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aje.model.entities.Usuario;
import aje.model.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService us;
	
	@GetMapping("/todos")
	public ResponseEntity<?> todos(){
		return ResponseEntity.ok(us.findAll());
	}
	
	@PostMapping("/login")
	 public ResponseEntity<?> login(@AuthenticationPrincipal Usuario usuario) {
	        // Si llega aquí, ya está autenticado por Spring Security (HTTP Basic)
	        us.findByUsernamePassword(usuario.getUsername(), usuario.getPassword());
	        return ResponseEntity.ok().body(us.findByUsernamePassword(usuario.getUsername(), usuario.getPassword()));
	    }
	
	@PostMapping("/registro")
	 public ResponseEntity<?> registro(@RequestBody Usuario usuario) {
	        // Si llega aquí, ya está autenticado por Spring Security (HTTP Basic)
			us.registrar(usuario);
	        return ResponseEntity.ok().body(usuario);
	    }

	

}
