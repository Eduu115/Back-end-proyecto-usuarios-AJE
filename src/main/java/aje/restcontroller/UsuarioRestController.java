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
import aje.model.entities.UsuarioDtoRegister;
import aje.model.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService us;
	
	@GetMapping("/") // lo usamos para la pagina de gestion admin TODO: Proteger
	public ResponseEntity<?> todos(){
		return ResponseEntity.ok(us.findAll());
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login(@AuthenticationPrincipal Usuario usuario) {
	    // Si llega aquí, ya está autenticado por Spring Security (HTTP Basic)
		Usuario u = us.findByUsernamePassword(usuario.getUsername(), usuario.getPassword());
	    return ResponseEntity.ok().body(u);
	}
	
	@PostMapping("/registro")
	public ResponseEntity<?> registro(@RequestBody UsuarioDtoRegister usuario) {
	    // Si llega aquí, ya está autenticado por Spring Security (HTTP Basic)
		Usuario ufinal = us.toUsuario(usuario);
		us.registrar(ufinal);
		return ResponseEntity.ok().body(ufinal);
	}
	
	@PostMapping("/registro/admin")
	public ResponseEntity<?> registroAdmin(@RequestBody Usuario usuario){ // aqui no pasa nada por que nos lo dan con todos los datos
		us.registrar(usuario);
		return ResponseEntity.ok().body(usuario);
	}

}
