package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.HeroiDTO;
import com.stefanini.hackaton.dto.JogadorDTO;
import com.stefanini.hackaton.entities.Heroi;
import com.stefanini.hackaton.entities.Jogador;

public class JogadorParserDTO extends AbstractParser<JogadorDTO, Jogador> {

	@Override
	public JogadorDTO toDTO(Jogador entity) {
		
		JogadorDTO dto = new JogadorDTO();
		
		HeroiDTO heroiDto = new HeroiDTO();
		
		heroiDto.setAtaque(entity.getHeroi().getAtaque());
		heroiDto.setDefesa(entity.getHeroi().getDefesa());
		heroiDto.setForca(entity.getHeroi().getForca());
		heroiDto.setId(entity.getHeroi().getId());
		heroiDto.setInteligencia(entity.getHeroi().getInteligencia());
		heroiDto.setNome(entity.getHeroi().getNome());
		heroiDto.setPoder(entity.getHeroi().getPoder());
		heroiDto.setVelocidade(entity.getHeroi().getVelocidade());
		heroiDto.setVida(entity.getHeroi().getVida());
		
		dto.setNickname(entity.getNickname());
		dto.setHeroiDto(heroiDto);

		return dto;
	}

	@Override
	public Jogador toEntity(JogadorDTO dto) {
		Jogador entity = new Jogador();
		entity.setNickname(dto.getNickname());

		return entity;
	}

}
