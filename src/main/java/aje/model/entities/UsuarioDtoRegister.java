package aje.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor

public class UsuarioDtoRegister {

	private String nombre;
	private String username;
	private String email;
	private String password;
	
}
