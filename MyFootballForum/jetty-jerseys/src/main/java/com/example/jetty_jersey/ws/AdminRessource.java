package com.example.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.Flight;
import dao.Topic;
import dao.User;
import dao.fao;
import dao.tao;

@Path("/admin")
public class AdminRessource {
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/theme")
	public long addTopic() {
		Topic top = new Topic("eric");
		
		if (top == null) {
			throw new BadRequestException("Missing payload");
		}
		long b = tao.getTopic_DAO().addTopic(top);
		System.out.println(b);
		return b;
	}
	

}
