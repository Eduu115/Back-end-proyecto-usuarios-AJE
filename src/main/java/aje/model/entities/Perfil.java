package aje.model.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity
@Table(name="perfiles")
public class Perfil implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_perfil")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idPerfil;
	private String nombre;

}
