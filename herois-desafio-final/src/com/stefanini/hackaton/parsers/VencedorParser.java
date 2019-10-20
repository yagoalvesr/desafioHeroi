package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.VencedorDTO;
import com.stefanini.hackaton.entities.Vencedor;

public class VencedorParser extends AbstractParser<VencedorDTO, Vencedor> {

	@Override
	public VencedorDTO toDTO(Vencedor entity) {

		VencedorDTO dto = new VencedorDTO();

		dto.setNickname(entity.getNickname());

		return dto;
	}

	@Override
	public Vencedor toEntity(VencedorDTO dto) {
		Vencedor entity = new Vencedor();
		entity.setNickname(dto.getNickname());

		return entity;
	}

}
