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

import com.app.tec.control.entity.Materia;
import com.app.tec.control.services.MateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private MateriaService service;
	
	@GetMapping
	public List<Materia> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Materia buscar(@PathVariable Long id) {
		return service.buscarMateria(id);
	}
	
	@PostMapping("/guardar")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Materia guardar(@RequestBody Materia materia) {
		Materia materiaNueva=null;
		materiaNueva=service.guardarMateria(materia);
		return materiaNueva;
	}
	
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Materia actualizar(@RequestBody Materia materia, @PathVariable Long id) {
		
		Materia materiaActual = service.buscarMateria(id);
		materiaActual.setNombre(materia.getNombre());
		materiaActual.setCreditos(materia.getCreditos());
		return service.guardarMateria(materiaActual);	
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code= HttpStatus.NOT_FOUND)
	public void elminar(@PathVariable Long id) {
		service.eliminarMateria(id);
	}
	
	
}
