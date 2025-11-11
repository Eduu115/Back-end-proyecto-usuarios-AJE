package aje.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aje.model.entities.Perfil;
import aje.model.service.PerfilServiceImplMy8;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/perfiles")
public class PerfilRestController {

	@Autowired
	PerfilServiceImplMy8 ps;
	
	@GetMapping("/")
	public List<Perfil> getPerfiles(){
		return ps.findAll();
	}
	@GetMapping("/{idPerfil}")
	public Perfil getPerfil(@PathVariable int idPerfil) {
		return ps.findById(idPerfil);
	}
	
}
