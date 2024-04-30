package com.app.tec.control.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tec.control.entity.Profesor;
import com.app.tec.control.repositories.ProfesorRepository;

@Service
public class ProfesorService {

	@Autowired
	private ProfesorRepository repository;
	
	
	public List<Profesor> listar(){
		return (List<Profesor>) repository.findAll();
	}
	
	public Profesor buscarProfesor(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Profesor guardarProfesor(Profesor datosProfesor) {
		return repository.save(datosProfesor);
	}
}
