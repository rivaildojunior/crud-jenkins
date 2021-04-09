package com.example.crudjenkins.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudjenkins.model.Usuario;
import com.example.crudjenkins.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioRepository usuarioRepository;

	@GetMapping("/ola")
	public String olaMundo() {
		return "Olá Mundo versão 2.0 release";
	}

	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save(@RequestBody Usuario input) {
		return this.usuarioRepository.save(input);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.usuarioRepository.findById(id).get());
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Iterable<Usuario>> findAll() {
		return ResponseEntity.ok().body(this.usuarioRepository.findAll());
	}

}
