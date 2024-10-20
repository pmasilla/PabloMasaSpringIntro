package com.keepcoding.webalumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.keepcoding.webalumnos.entity.Alumno;
import com.keepcoding.webalumnos.service.AlumnoService;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoService servicio;
	
	@GetMapping("/alumnos")
	public String listarAlumnos(Model modelo) {
		modelo.addAttribute("alumnos", servicio.listarAlumno());
		return "alumno";
	}
	
	@GetMapping("/alumnos/new")
	public String viewFormularioAlta(Model modelo) {
		Alumno alumno = new Alumno();
		modelo.addAttribute("alumno", alumno);
		return "new_alumno";
	}
	
	@PostMapping("/alumnos")
	public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		servicio.guardarAlumno(alumno);
		return "redirect:/alumnos";
	}
	 @GetMapping("/alumno/delete/{id}")
	public String borrarAlumno(@PathVariable Long id) {
		servicio.borrarAlumno(id);
		return "redirect:/alumnos";
	}
	 @GetMapping("/alumno/editar/{id}")
	    public String viewFormularioEdit(@PathVariable Long id, Model modelo) {
	        Alumno editAlumno = servicio.alumnoPorId(id);
	        modelo.addAttribute("alumno", editAlumno);
	        return "edit_alumno";
	    }

	 @PostMapping("/alumnos/edit/{id}")
	    public String editarAlumno(@PathVariable Long id, @ModelAttribute("alumno") Alumno alumno) {
	        Alumno editAlumno = servicio.alumnoPorId(id);
	        editAlumno.setNombre(alumno.getNombre());
	        editAlumno.setApellido(alumno.getApellido());
	        editAlumno.setEmail(alumno.getEmail());
	        editAlumno.setTelefono(alumno.getTelefono());
	        editAlumno.setDni(alumno.getDni());
	        editAlumno.setFechaNac(alumno.getFechaNac());

	        servicio.guardarAlumno(editAlumno);
	        return "redirect:/alumnos";
	    }
	}