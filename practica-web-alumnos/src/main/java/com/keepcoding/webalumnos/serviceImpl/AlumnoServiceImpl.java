package com.keepcoding.webalumnos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.webalumnos.entity.Alumno;
import com.keepcoding.webalumnos.repository.AlumnoRepository;
import com.keepcoding.webalumnos.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public List<Alumno> listarAlumno() {
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno guardarAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public Alumno alumnoPorId(Long id) {
		return alumnoRepository.findById(id).get();
	}

	@Override
	public void borrarAlumno(Long id) {
		alumnoRepository.deleteById(id);
	}

}
