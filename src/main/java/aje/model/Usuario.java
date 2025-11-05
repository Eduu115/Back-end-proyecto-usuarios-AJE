package aje.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity
@Table(name="USUARIOS")
public class Usuario implements UserDetails, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	private String nombre;
	private String apellidos;
	private int enabled;
	@Column(name="FECHA_REGISTRO")
	private LocalDate fechaRegistro;
	@Column(name="FECHA_NACIMIENTO")
	private LocalDate fechaNacimiento;
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Spring espera "ROLE_ADMIN", "ROLE_USER", etc.
        return List.of(new SimpleGrantedAuthority(perfil.getNombre()));
	}
	
	
	

}
