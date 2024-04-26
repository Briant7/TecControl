package com.app.tec.control.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.tec.control.entity.Profesor;
import com.app.tec.control.services.ProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

	@Autowired
	private ProfesorService service;
	
	@GetMapping
	public List<Profesor> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Profesor buscar(@PathVariable Long id) {
		return service.buscarProfesor(id);
	}
}
