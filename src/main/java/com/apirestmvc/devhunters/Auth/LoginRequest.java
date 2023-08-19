package com.apirestmvc.devhunters.Auth;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("ALL")
@Data // Crea los getters y setter de las propiedades de la clase
@Builder // Nos permite la creacion de objetos/instancias de la clase
@NoArgsConstructor // No crea el constructor vacio (sin argumentos)
public class LoginRequest {
	private String username;
	private String password;
}
