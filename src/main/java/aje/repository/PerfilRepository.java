package aje.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aje.model.entities.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer>{
	
}
