package com.keepcoding.webalumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.keepcoding.webalumnos.entity.Usuario;
import com.keepcoding.webalumnos.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("/registro")
	public String formularioAlta(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "registro";
	}
	
	@PostMapping("/registro")
	public String altaUsuario(Usuario usuario) {
		servicio.guardarUsuario(usuario);
		return "redirect:/login";
	}
	@GetMapping({"/" , "/login"})
	public String mostrarFormularioLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUsuario(Usuario usuario, Model modelo) {
	    Usuario usuarioValidado = servicio.buscarPorUsername(usuario.getUsername());

	    if (usuarioValidado != null && usuarioValidado.getPassword().equals(usuario.getPassword())) {
	        return "redirect:/alumnos";
	    } else {
	        modelo.addAttribute("error", "Usuario o contraseña incorrectos");
	        return "login";
	    }
	}
	

}
