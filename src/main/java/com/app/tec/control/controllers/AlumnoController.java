package com.app.tec.control.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.tec.control.entity.Alumno;
import com.app.tec.control.services.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService service;
	
	@GetMapping
	public List<Alumno> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Alumno buscar(@PathVariable Long id) {
		return service.buscarAlumno(id);
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Alumno guardar(@RequestBody Alumno alumno) {
		Alumno alumnoNuevo=null;
		alumnoNuevo= service.guardarAlumno(alumno);
		return alumnoNuevo;
	}
}
