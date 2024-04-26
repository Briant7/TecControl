package com.app.tec.control.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
