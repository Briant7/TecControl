package com.app.tec.control.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tec.control.entity.Alumno;
import com.app.tec.control.repositories.AlumnoRepository;

@Service
public class AlumnoService {
	
	@Autowired
	private AlumnoRepository repository;
	
	
	public List<Alumno> listar(){
		return (List<Alumno>) repository.findAll();
	}

}
