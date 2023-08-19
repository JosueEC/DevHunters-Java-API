package com.apirestmvc.devhunters.Auth.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 Estas clases son usadas para recibir y crear objetos con propiedades
 especificas, como las interfaces en TypeScript que nos permiten tipar
 las request y response de la funciones en los servicios
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String country;
}
