package aje.restcontroller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aje.model.entities.Perfil;
import aje.model.entities.Usuario;
import aje.model.entities.UsuarioDtoRegister;
import aje.model.service.PerfilService;
import aje.model.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService us;
	
	@Autowired
	private PerfilService ps;

	@GetMapping("/") // lo usamos para la pagina de gestion admin TODO: Proteger
	public ResponseEntity<?> todos(){
		return ResponseEntity.ok(us.findAll());
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@AuthenticationPrincipal Usuario usuario) {
	    // Si llega aquí, ya está autenticado por Spring Security (HTTP Basic)
		Usuario u = us.findByUsernamePassword(usuario.getUsername(), usuario.getPassword());
	    return ResponseEntity.ok().body(u);
	}
	
	@PostMapping("/registro")
	public ResponseEntity<?> registro(@RequestBody UsuarioDtoRegister usuario) {
	    // Si llega aquí, ya está autenticado por Spring Security (HTTP Basic)
		System.out.println(usuario);
		Usuario ufinal = us.toUsuario(usuario);
		us.registrar(ufinal);
		return ResponseEntity.ok().body(ufinal);
	}
	
	@PostMapping("/registro/admin")
	public ResponseEntity<?> registroAdmin(@RequestBody Usuario usuario){
	    Perfil p = ps.findById(usuario.getPerfil().getIdPerfil());
	    usuario.setPerfil(p);
	    usuario.setEnabled(1);
	    usuario.setFechaRegistro(LocalDate.now());
	    Usuario guardado = us.registrar(usuario);
	    return ResponseEntity.ok(guardado);
	}

	
	@PutMapping("/actualizar/{username}")
	public ResponseEntity<?> actualizar(@PathVariable String username, @RequestBody Usuario usuario) {
	    usuario.setUsername(username);
	    Usuario actualizado = us.actualizar(usuario);
	    return ResponseEntity.ok(actualizado);
	}

	@DeleteMapping("/eliminar/{username}")
	public ResponseEntity<?> eliminar(@PathVariable String username) {
	    int resultado = us.eliminarPorUsername(username);
	    return ResponseEntity.ok(resultado); // 1=ok, 0=no existe
	}


}
