package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.entities.Heroi;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.service.HeroiService;
import com.stefanini.hackaton.service.JogadorService;

@Path("/jogador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorApi {

	@Inject
	private JogadorService jogadorService;

	@Inject
	private HeroiService heroiService;

	@GET
	public Response listar() {
		return Response.ok(jogadorService.listar()).build();
	}

	
	@GET
	@Path("/{nickname}/{senha}")
	public Response login(@PathParam("nickname") String nickname, @PathParam("senha") String senha) throws NegocioException{

		return Response.ok(jogadorService.fazerLogin(nickname, senha)).build();
	}

	@POST
	public Response cadastrar(Jogador jogador) throws NegocioException{

		jogadorService.adicionar(jogador);

		return Response.ok().build();
		
	}

	@POST
	@Path("/cadastrar/{id}")
	public Response cadastrar(@PathParam("id") Integer id, Jogador jogador) throws NegocioException{

		System.out.println("Entrou no post cadastrar");
		
		Heroi heroi = new Heroi();
		heroi = heroiService.buscarPorId(id);

		jogadorService.cadastrar(heroi, jogador);

		return Response.ok().build();
	}
}
