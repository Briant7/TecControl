package com.app.tec.control.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.tec.control.entity.Profesor;
import com.app.tec.control.services.ProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

	@Autowired
	private ProfesorService service;

	@GetMapping
	public List<Profesor> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Profesor buscar(@PathVariable Long id) {
		return service.buscarProfesor(id);
	}

	@PostMapping("/guardar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Profesor guardar(@RequestBody Profesor profesor) {
		Profesor profesorNuevo = null;
		profesorNuevo = service.guardarProfesor(profesor);
		return profesorNuevo;
	}

	@PutMapping("/actualizar/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Profesor actualizar(@RequestBody Profesor profesor, @PathVariable Long id) {

		Profesor profesorActual = null;
		profesorActual = service.buscarProfesor(id);
		profesorActual.setNombre(profesor.getNombre());
		profesorActual.setApellidos(profesor.getApellidos());
		
		Profesor profesorActualizado = null;
		profesorActualizado = service.guardarProfesor(profesorActual);
		return profesorActualizado;
		
//		Profesor profesorActual = service.buscarProfesor(id);
//		profesorActual.setNombre(profesor.getNombre());
//		profesorActual.setApellidos(profesor.getApellidos());
//		return service.guardarProfesor(profesorActual);

	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code= HttpStatus.NOT_FOUND)
	public void eliminar(@PathVariable Long id) {
		service.eliminarProfesor(id);
	}
}
