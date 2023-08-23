package com.apirestmvc.devhunters.Auth.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("ALL")
/*
 Estas clases son usadas para recibir y crear objetos con propiedades
 especificas, como las interfaces en TypeScript que nos permiten tipar
 las request y response de la funciones en los servicios
*/
@Data // Crea los getters y setter de las propiedades de la clase
@Builder // Nos permite la creacion de objetos/instancias de la clase
@NoArgsConstructor // No crea el constructor vacio (sin argumentos)
@AllArgsConstructor
public class LoginRequest {
	private String username;
	private String password;
}
