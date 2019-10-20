package com.stefanini.hackaton.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.HeroiDTO;
import com.stefanini.hackaton.dto.JogadorDTO;
import com.stefanini.hackaton.entities.Vencedor;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.persistence.JogadorDAO;

public class BatalhaService {

	@Inject
	JogadorDAO dao;

	@Inject
	JogadorParserDTO parser;

	public List<JogadorDTO> listar() {
		return parser.toDTO(dao.list());
	}

	public Vencedor batalha(String nickNameJogador, String nickNameAdversario) {

		JogadorDTO jogadorDto = parser.toDTO(dao.findByNickname(nickNameJogador));
		JogadorDTO adversarioDto = parser.toDTO(dao.findByNickname(nickNameAdversario));

		HeroiDTO heroiJogador = jogadorDto.getHeroiDto();
		HeroiDTO heroiAdversario = adversarioDto.getHeroiDto();

		int round = 0;
		int turno = 0;

		for (round = 0; round <= 10;) {

			System.out.println("Round" + round);

			if (turno % 2 == 0) {

				System.out.println("Turno Thanos");

				double dano = 0;

				dano = atacar(heroiJogador);

				System.out.println("Dano do Thanos: " + dano);

				double danoRecebido = 0;

				double novaVida = receberAtaque(heroiAdversario, dano);

				System.out.println("Nova Vida do Thor: " + novaVida);

				heroiAdversario.setVida(novaVida);

				turno++;

			} else {

				System.out.println("Turno Thor");

				double dano = 0;

				dano = atacar(heroiAdversario);

				System.out.println("Dano do Thor: " + dano);

				double danoRecebido = 0;

				double novaVida = receberAtaque(heroiJogador, dano);

				System.out.println("Nova Vida do Thanos: " + novaVida);

				heroiJogador.setVida(novaVida);

				turno++;
				round++;

			}

			if (heroiJogador.getVida() < 0 || heroiAdversario.getVida() < 0) {
				round = 11;
			}

			System.out.println("");

		}

		Vencedor vencedor = new Vencedor();

		if (heroiJogador.getVida() > heroiAdversario.getVida()) {
			vencedor.setNickname(jogadorDto.getNickname());
			return vencedor;
		} else {
			vencedor.setNickname(adversarioDto.getNickname());
			return vencedor;
		}

	}

	private double atacar(HeroiDTO heroi) {

		double dano = 0;

		double chance = heroi.getInteligencia() * 0.8;
		double porcentagem = Math.random() * 100;

		if (chance > porcentagem) {
			System.out.println("crítico");
			dano = ((heroi.getAtaque() * heroi.getForca()) * 250) * 2;
			return dano;
		} else {
			dano = (heroi.getAtaque() * heroi.getForca() * 250);
			return dano;
		}

	}

	private double receberAtaque(HeroiDTO heroi, double dano) {

		double danoRecebido = 0;

		double chance = heroi.getInteligencia() * 0.4;
		double porcentagem = Math.random() * 100;

		if (chance > porcentagem) {
			System.out.println("dodge");
			danoRecebido = heroi.getVida();
			return danoRecebido;
		} else {
			dano = dano - (heroi.getDefesa() * 2.3);
			danoRecebido = heroi.getVida() - dano;
			System.out.println("Dano: " + dano);
		}

		return danoRecebido;

	}

}
