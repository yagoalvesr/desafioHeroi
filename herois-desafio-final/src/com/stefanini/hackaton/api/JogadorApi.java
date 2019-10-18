package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.service.JogadorService;

@Path("/jogador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorApi {

	@Inject
	private JogadorService jogadorService;

	@GET
	public Response listar() {
		return Response.ok(jogadorService.listar()).build();
	}
	
	@POST
	public Response adicionar(Jogador jogador) {
		
		jogadorService.adicionar(jogador);
		
		return Response.ok().build();
	}
}
