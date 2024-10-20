package com.keepcoding.webalumnos.service;

import java.util.List;

import com.keepcoding.webalumnos.entity.Alumno;

public interface AlumnoService {
	
	//Mostrar todos los alumnos
	List<Alumno> listarAlumno();
	//Guardar un registro de alumno
	Alumno guardarAlumno(Alumno alumno);
	//Buscar un alumdno por su id
	Alumno alumnoPorId(Long id);
	//Borrar un registro de alumno
	void borrarAlumno(Long id);

}
