package com.apirestmvc.devhunters.Demo.User.models;

import com.apirestmvc.devhunters.Demo.User.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/*
 La notacion @Builder de lombok, nos permite usar el patron builder para la
 creacion de objetos de nuestra clase, esta es otra forma mas comoda de
 instanciar objetos. Es lo mismo que si crearamos la clase builder dentro
 de esta misma clase
*/
@SuppressWarnings("ALL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(
			name = "name",
			nullable = false
	)
	private String name;
	@Column(
			name = "email",
			unique = true,
			nullable = false
	)
	private String email;
	@Column(
			name = "password",
			nullable = false
	)
	private String password;
	@Column(
			name = "role",
			nullable = false
	)
	/*
	 Esta anotation le indica a spring boot que esta columna
	 es un enum de tipo string
	*/
	@Enumerated(EnumType.STRING)
	Role role;
	
	// Este metodo retorna el rol del usuario logeado
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}
	
	@Override
	public String getUsername() {
		return null;
	}
	
	/*
	 Los metodos que devuelven un boolean se colocan en true, debido
	 a que estas verificaciones van a ser controlada en el service de
	 JWT
	*/
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
