package com.example.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import dao.Topic;

import dao.tao;

@Path("/home2")
public class AccueilRessource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search2")
	public List<Topic> getTopic() {

		List<Topic> test_result = null;
		try {
			test_result = tao.getTopic_DAO().getTopic();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (test_result == null) {
			throw new NotFoundException("Invalid parameter");
		}
		return test_result;
	}

}
