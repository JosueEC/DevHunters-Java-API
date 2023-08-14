package com.apirestmvc.devhunters.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
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
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	
	}
}
