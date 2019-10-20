package com.stefanini.hackaton.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.HeroiDTO;
import com.stefanini.hackaton.entities.Heroi;
import com.stefanini.hackaton.parsers.HeroiParserDTO;
import com.stefanini.hackaton.persistence.HeroiDAO;

public class HeroiService {

	@Inject
	HeroiParserDTO parser;
	
	@Inject
	HeroiDAO heroiDao;


	public List<HeroiDTO> listar() {
		return parser.toDTO(heroiDao.list());
	}
	
	public Heroi buscarPorId(Integer id) {
		return heroiDao.findById(id);
	}

}
