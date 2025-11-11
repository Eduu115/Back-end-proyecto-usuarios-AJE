package aje.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aje.model.entities.Perfil;
import aje.repository.PerfilRepository;

@Service
public class PerfilServiceImplMy8 implements PerfilService{

	@Autowired
	PerfilRepository prepo;
	
	@Override
	public Perfil findById(int idPerfil) {
		return prepo.findById(idPerfil).orElse(null);
	}

	@Override
	public List<Perfil> findAll() {
		return prepo.findAll();
	}

}
