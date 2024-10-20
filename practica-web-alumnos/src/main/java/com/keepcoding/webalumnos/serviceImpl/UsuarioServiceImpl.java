package com.keepcoding.webalumnos.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcoding.webalumnos.entity.Usuario;
import com.keepcoding.webalumnos.repository.UsuarioRepository;
import com.keepcoding.webalumnos.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

}
