package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.entities.UsuarioLogado;
import com.stefanini.hackaton.persistence.Repositorio;
import com.stefanini.hackaton.service.BatalhaService;
import com.stefanini.hackaton.service.JogadorService;

@Path("/batalha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BatalhaApi {


	@Inject
	private JogadorService jogadorService;
	
	@Inject
	private BatalhaService batalhaService;
	
	@Inject
	private Repositorio repo;
	

	@GET
	@Path("/{nickname}/{nickname2}")
	public Response batalhar(@PathParam("nickname") String nickNameAdversario, @PathParam("nickname2")String nickName) {		
						
		return Response.ok(batalhaService.batalha(nickName, nickNameAdversario)).build();
	}

}
