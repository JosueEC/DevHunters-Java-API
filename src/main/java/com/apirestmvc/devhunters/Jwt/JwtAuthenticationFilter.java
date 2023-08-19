package com.apirestmvc.devhunters.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
 OncePerRequestFilter es una clase asbtracta que nos permite crear
 filtros personalizados de autenticacion, el OncePer significa que
 el filtro se aplicara una sola vez por cada request
*/
@SuppressWarnings("ALL")
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	/*
	 Esta clase el la forma en la que podemos crear un filtro personalizado
	 de autenticacion. Spring Security trabaja como el patron de comportamiento
	 "Cadena de Responsabilidad", estos metodos son como los middlewares en Express
	 por aqui pasa la request, la response y el filterchain, el cual es como la
	 funcion next en Express, que en este caso haria la funcion de pasar al
	 siguiente filtro
	*/
	
	/*
	 En esta funcion podemos ejecutar el codigo que queremos que se ejecute cuando
	 pasa la request por el filtro, en este caso, revisamos si la peticion no tiene
	 token, entonces se trata de un registro. y lo enviamos al siguiente filtro, caso
	 contrario
	*/
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		final String token = getTokenFromRequest(request);
		
		if (token == null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		filterChain.doFilter(request, response);
	}
	
	/*
	 Esta funcion es la que obtiene el token que viene en el header de la
	 request. Se verifica que el token no venga vacio y que empieze con la
	 palabra Bearer, si es asi, se recorta solo el token y se retorna, caso
	 contrario devuelve null
	*/
	private String getTokenFromRequest(HttpServletRequest request) {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if (!StringUtils.hasText(authHeader) && !authHeader.startsWith("Bearer")) {
			return null;
		}
		
		return authHeader.substring(7);
	}
}
