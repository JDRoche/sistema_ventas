package com.sistventas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistventas.domain.dto.AuthenticationRequest;
import com.sistventas.domain.dto.AuthenticationResponse;
import com.sistventas.domain.service.VentasUserDetailsService;
import com.sistventas.web.security.JWTUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager _authenticationManager;
	
	@Autowired
	private VentasUserDetailsService _ventasUserDetailsService;
	
	@Autowired
	private JWTUtil _jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest  request){
		try {
			_authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			UserDetails userDetails = _ventasUserDetailsService.loadUserByUsername(request.getUsername());
			String jwt = _jwtUtil.generateToken(userDetails);
			
			return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}
