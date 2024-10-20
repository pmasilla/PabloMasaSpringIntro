package com.keepcoding.webalumnos.service;

import com.keepcoding.webalumnos.entity.Usuario;

public interface UsuarioService {
	
	Usuario guardarUsuario(Usuario usuario);
	Usuario buscarPorUsername(String username);
}
