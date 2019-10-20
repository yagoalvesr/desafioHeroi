package com.stefanini.hackaton.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.JogadorDTO;
import com.stefanini.hackaton.entities.Heroi;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.persistence.JogadorDAO;
import com.stefanini.hackaton.persistence.Repositorio;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

public class JogadorService {

	@Inject
	JogadorParserDTO parser;

	@Inject
	JogadorDAO jogadorDao;

	@Inject
	Repositorio repo;

	public List<JogadorDTO> listar() {
		return parser.toDTO(jogadorDao.list());
	}

	public JogadorDTO fazerLogin(String nickname, String senha) throws NegocioException {

		try {

			if (validarSenha(nickname, senha) == false) {
				throw new NegocioException("Senha Inválida");
			} else {
				return parser.toDTO(jogadorDao.findByNickname(nickname));
			}
		} catch (Exception e) {
			throw new NegocioException("Usuário ou Senha inválidos", e);
		}

	}

	private Boolean validarSenha(String nickname, String senha) {

		if (jogadorDao.findByNickname(nickname).getSenha().equals(senha)) {
			return true;
		} else {
			return false;
		}

	}

	public JogadorDTO buscaPorId(Integer id) {

		return parser.toDTO(jogadorDao.findById(id));
	}

	public void cadastrar(Heroi heroi, Jogador jogador) throws NegocioException {

		int i = verificarNick(jogador);
		
		System.out.println("Verificador: " + i);
		
		if(i < 1) {
		
				jogador.setHeroi(heroi);
				jogadorDao.insert(jogador);
				
		} else {
			throw new NegocioException("Nick já existe, informe outro!");
		}
		
	}

	private Integer verificarNick(Jogador jogador) {

		List<Jogador> listJogador = (jogadorDao.list());
		

		int i = 0;

		for (Jogador j : listJogador) {
			
			System.out.println(jogador.getNickname());
			System.out.println(j.getNickname());
			if (jogador.getNickname().equals(j.getNickname())) {
				i++;
				
				System.out.println(i);
			}
		}

		return i;

	}

	public void adicionar(Jogador jogador) throws NegocioException {
		if (jogadorDao.findByNickname(jogador.getNickname()) != null) {
			throw new NegocioException("Nickname já existe, escolha outro");
		} else {
			jogadorDao.insert(jogador);
		}
	}

}
