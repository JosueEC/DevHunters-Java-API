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
	 Esta funcion controla el proceso del flujo que realiza Spring
	 security para autenticar a un usuarios, en el caso de que el
	 token venga vacio se trata de un registro, por lo que lo
	 pasamos al siguiente filtro. Caso contrario es un logeo, por lo
	 que igualmente lo pasamos al siguiente filtro
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
	 Esta funcion obtiene el token desde la cabecera o header de la
	 peticion http, la cual viene en el request de la peticion.
	*/
	private String getTokenFromRequest(HttpServletRequest request) {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if (!StringUtils.hasText(authHeader) && !authHeader.startsWith("Bearer")) {
			return null;
		}
		
		return authHeader.substring(7);
	}
}
