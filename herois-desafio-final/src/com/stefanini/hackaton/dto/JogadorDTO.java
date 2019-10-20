package com.stefanini.hackaton.dto;

import java.io.Serializable;

public class JogadorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private HeroiDTO heroiDto;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public HeroiDTO getHeroiDto() {
		return heroiDto;
	}

	public void setHeroiDto(HeroiDTO heroiDto) {
		this.heroiDto = heroiDto;
	}
	
	



}
