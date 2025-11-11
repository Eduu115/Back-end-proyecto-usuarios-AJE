package aje.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aje.model.entities.Perfil;

@RestController
@RequestMapping("/perfiles")
@CrossOrigin(origins="*")
public class PerfilRestController {

	@GetMapping("/")
	public List<Perfil> getPerfiles(){
		return null;
	}
	@GetMapping("/{id}")
	public Perfil getPerfil() {
		return null;
	}
	
}
