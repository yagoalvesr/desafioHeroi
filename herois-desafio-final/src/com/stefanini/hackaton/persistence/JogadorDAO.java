package com.stefanini.hackaton.persistence;

import com.stefanini.hackaton.entities.Jogador;

public class JogadorDAO extends GenericDAO<Integer, Jogador> {

	public Jogador findByNickname(String nickname) {
		return (Jogador) getEntityManager()
				.createNamedQuery("Jogador.findByNickname")
				.setParameter("nickname", nickname)
				.getSingleResult();
	}


}
