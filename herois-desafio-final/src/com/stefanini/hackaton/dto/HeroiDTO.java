package com.stefanini.hackaton.dto;

import java.io.Serializable;

public class HeroiDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double ataque;
	private Double defesa;
	private Integer id;
	private Double inteligencia;
	private String nome;
	private Double poder;
	private Double velocidade;
	private Double forca;
	private Double vida;

	
	
	public Double getAtaque() {
		return ataque;
	}

	public void setAtaque(Double ataque) {
		this.ataque = ataque;
	}

	public Double getDefesa() {
		return defesa;
	}

	public void setDefesa(Double defesa) {
		this.defesa = defesa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Double inteligencia) {
		this.inteligencia = inteligencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPoder() {
		return poder;
	}

	public void setPoder(Double poder) {
		this.poder = poder;
	}

	public Double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}

	public Double getForca() {
		return forca;
	}

	public void setForca(Double forca) {
		this.forca = forca;
	}

	public Double getVida() {
		return vida;
	}

	public void setVida(Double vida) {
		this.vida = vida;
	}

}
