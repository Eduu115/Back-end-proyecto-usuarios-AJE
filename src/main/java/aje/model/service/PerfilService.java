package aje.model.service;

import java.util.List;

import aje.model.entities.Perfil;

public interface PerfilService {

	Perfil findById(int idPerfil);
	List<Perfil> findAll();
	
}
