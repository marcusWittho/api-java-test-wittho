package org.wittho.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.wittho.dto.PersonDto;
import org.wittho.service.PersonService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonController {

  @Inject
  private PersonService service;
  
  @GET
  @Path("/test")
  public Response test() {
    return Response.ok(service.test()).build();
  }
  
  @GET
  public Response listAll() {
    return Response.ok(service.listAll()).build();
  }
  
  @GET
  @Path("/{id}")
  public Response getById(@PathParam("id") Long id) {
    return Response.ok(service.getById(id)).build();
  }
  
  @POST
  public Response save(PersonDto personDto) throws Exception {
    return Response.ok(service.save(personDto)).build();
  }
  
  @PATCH
  @Path("/{id}")
  public Response update(@PathParam("id") Long id, PersonDto personDto) {
    return Response.ok(service.update(id, personDto)).build();
  }
  
  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") Long id) {
    return Response.ok(service.delete(id)).build();
  }
}
