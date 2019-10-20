package com.stefanini.hackaton.persistence;

import java.util.HashMap;
import java.util.Map;

import com.stefanini.hackaton.entities.UsuarioLogado;

public class Repositorio {
	
	private Map<Integer, String> mapUsuario = new HashMap<>();
	
	public Map<Integer, String> getMapConta(){
		return mapUsuario;
	}

}
