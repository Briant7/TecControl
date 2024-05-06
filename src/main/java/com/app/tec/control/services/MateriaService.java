package com.app.tec.control.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tec.control.entity.Materia;
import com.app.tec.control.repositories.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository repository;
	
	
	public List<Materia> listar(){
		return (List<Materia>) repository.findAll();
	}
	
	public Materia buscarMateria(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Materia guardarMateria(Materia datosmateria) {
		return repository.save(datosmateria);
	}
	
	public void eliminarMateria(Long id) {
		repository.deleteById(id);
	}
}
