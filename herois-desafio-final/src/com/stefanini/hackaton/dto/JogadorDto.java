package com.stefanini.hackaton.dto;

import java.io.Serializable;

public class JogadorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private HeroiDto heroiDto;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public HeroiDto getHeroiDto() {
		return heroiDto;
	}

	public void setHeroiDto(HeroiDto heroiDto) {
		this.heroiDto = heroiDto;
	}
	
	



}
